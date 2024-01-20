package com.dmc3105;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilesScanner implements Iterator<String>, Closeable, AutoCloseable {
    private final Collection<FileInputStream> fileInputStreamCollection;
    private final Iterator<FileInputStream> fileIterator;
    private Scanner currentScanner;

    public FilesScanner(String... strings) throws FileNotFoundException
    {
        this(Arrays.stream(strings).toList());
    }
    public FilesScanner(Collection<String> files) throws FileNotFoundException {
        Collection<FileInputStream> streams = new LinkedList<>();
        for (var file: files) {
            streams.add(new FileInputStream(file));
        }
        if (streams.isEmpty()) {
            throw new IllegalArgumentException("Count of files cannot be equal to 0");
        }
        fileInputStreamCollection = streams;
        fileIterator = streams.iterator();

        currentScanner = new Scanner(fileIterator.next());
        makeActualScanner();
    }

    @Override
    public boolean hasNext() {
        return currentScanner.hasNext();
    }

    @Override
    public String next() {
        String returningValue = currentScanner.next();
        makeActualScanner();
        return returningValue;
    }

    @Override
    public void close() throws IOException {
        for (var fis : fileInputStreamCollection) {
            fis.close();
        }
    }

    public boolean hasNextLine() {
        return currentScanner.hasNextLine();
    }

    public String nextLine() {
        String returningValue = currentScanner.nextLine();
        makeActualScanner();
        return returningValue;
    }

    private void makeActualScanner() {
        while (!currentScanner.hasNext() && fileIterator.hasNext()) {
            currentScanner = new Scanner(fileIterator.next());
        }
    }
}
