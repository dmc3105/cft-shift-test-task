package com.dmc3105;

import com.dmc3105.typeidentifier.Type;

import java.io.*;
import java.util.HashMap;

public class TypedFilePrinter implements Closeable, AutoCloseable{

    private final String outputDirPath;
    private final String outputFilePrefix;
    private final boolean appendToFiles;
    private final HashMap<Type, String> typeFileNameHashMap;
    private HashMap<Type, PrintWriter> typePrintWriterMap = new HashMap<>();

    public TypedFilePrinter(TypedFilePrinterBuilder builder) {
        this.outputDirPath = builder.outputDirPath;
        this.outputFilePrefix = builder.outputFilePrefix;
        this.appendToFiles = builder.appendInFiles;
        this.typeFileNameHashMap = builder.typeFileNameHashMap;
    }



    @Override
    public void close() throws IOException {
        for (var printer:
             typePrintWriterMap.values()) {
            printer.close();
        }
    }



    public static TypedFilePrinterBuilder builder()
    {
        return new TypedFilePrinterBuilder();
    }



    public void printByType(String value, Type type) throws FileNotFoundException {
        getPrintWriterByType(type).println(value);
    }



    private PrintWriter getPrintWriterByType(Type type) throws FileNotFoundException {
        if (!typePrintWriterMap.containsKey(type))
        {
            String fullPath = this.outputDirPath + this.outputFilePrefix + typeFileNameHashMap.get(type);
            FileOutputStream fos = new FileOutputStream(fullPath, this.appendToFiles);
            typePrintWriterMap.put(type, new PrintWriter(fos));
        }
        return typePrintWriterMap.get(type);
    }



    public static class TypedFilePrinterBuilder {
        private String outputDirPath = "";
        private String outputFilePrefix = "";
        private boolean appendInFiles = false;

        private HashMap<Type, String> typeFileNameHashMap = new HashMap<>();

        public TypedFilePrinterBuilder setOutputDirPath(String outputDirPath) {
            this.outputDirPath = outputDirPath;
            return this;
        }

        public TypedFilePrinterBuilder setOutputFilePrefix(String outputFilePrefix) {
            this.outputFilePrefix = outputFilePrefix;
            return this;
        }

        public TypedFilePrinterBuilder setAppendInFiles(Boolean appendInFiles) {
            this.appendInFiles = appendInFiles;
            return this;
        }

        public TypedFilePrinterBuilder addFile(Type type, String fileName) {
            typeFileNameHashMap.put(type, fileName);
            return this;
        }

        public TypedFilePrinterBuilder setFiles(HashMap<Type, String> typeFileNameHashMap) {
            this.typeFileNameHashMap = typeFileNameHashMap;
            return this;
        }

        public TypedFilePrinter build() throws FileNotFoundException {
            return new TypedFilePrinter(this);
        }
    }
}
