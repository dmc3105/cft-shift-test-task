package com.dmc3105;

import com.dmc3105.typeidentifier.RegexTypeIdentifier;
import com.dmc3105.typeidentifier.Type;
import com.dmc3105.typeidentifier.TypeIdentifier;
import org.apache.commons.cli.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

public class App
{
    public static void main(String[] args) {
        CommandLine cmd = null;
        try {
            cmd = CreateCommandLine(args);
        } catch (ParseException e) {
            printException(e);
            System.exit(1);
        }

        try (FilesScanner filesScanner = new FilesScanner(cmd.getArgList());
             TypedFilePrinter printer = createTypedFilePrinter(cmd)){
            TypeIdentifier typeIdentifier = new RegexTypeIdentifier();

            while (filesScanner.hasNextLine()) {
                String line = filesScanner.nextLine();
                if (line.isEmpty())
                    continue;
                Type type = typeIdentifier.identify(line);
                printer.printByType(line, type);
            }
        } catch (FileNotFoundException e) {
            printException(e);
            System.exit(2);
        } catch (IOException e) {
            printException(e);
            System.exit(3);
        }

        if (cmd.hasOption("s") || cmd.hasOption("f")) {
            ApplicationStatisticsCollector collector = collectStatistics(
                    cmd.getArgList(),
                    cmd.hasOption("s"),
                    cmd.hasOption("f"));
            collector.printStatistics();
        }
    }

    private static ApplicationStatisticsCollector collectStatistics(Collection<String> files,
                                                                    boolean useShortStatistics,
                                                                    boolean useFullStatistics)
    {
        ApplicationStatisticsCollector collector = createApplicationStatisticsCollector(
                useShortStatistics,
                useFullStatistics);
        TypeIdentifier typeIdentifier = new RegexTypeIdentifier();

        try (FilesScanner scanner = new FilesScanner(files)) {
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                if (line.isEmpty())
                    continue;
                collector.collectStatistics(line, typeIdentifier);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return collector;
    }

    private static CommandLine CreateCommandLine(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        return parser.parse(createOptions(), args);
    }

    private static Options createOptions() {
        Options options = new Options();
        options.addOption(Option.builder("o").hasArg().build());
        options.addOption(Option.builder("p").hasArg().build());
        options.addOption(Option.builder("a").build());
        options.addOption(Option.builder("s").build());
        options.addOption(Option.builder("f").build());
        return options;
    }

    private static TypedFilePrinter createTypedFilePrinter(CommandLine commandLine) throws FileNotFoundException {
        var builder = TypedFilePrinter.builder();

        if (commandLine.hasOption("o"))
            builder.setOutputDirPath(commandLine.getOptionValue("o"));

        if (commandLine.hasOption("p"))
            builder.setOutputFilePrefix(commandLine.getOptionValue("p"));

        builder.addFile(Type.FLOAT, "floats.txt");
        builder.addFile(Type.STRING, "strings.txt");
        builder.addFile(Type.INTEGER, "integers.txt");

        builder.setAppendInFiles(commandLine.hasOption("a"));

        return  builder.build();
    }

    private static ApplicationStatisticsCollector createApplicationStatisticsCollector(
            boolean useShortStatistics,
            boolean useFullStatistics)
    {
        StatisticsCollectorsFactory factory;
        if (useShortStatistics) {
            factory = new ShortStatisticsCollectorsFactory();
        } else if (useFullStatistics) {
            factory = new FullStatisticsCollectorsFactory();
        } else {
            throw new IllegalArgumentException("Cannot create factory without any option");
        }
        return new ApplicationStatisticsCollector(factory);
    }

    private static void printException(Exception e)
    {
        System.out.println("Во время выполнения программы произошла ошибка\n" + e.getMessage());
    }
}
