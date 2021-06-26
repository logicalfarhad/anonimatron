package com.rolfje.anonimatron.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CsvFileWriter implements RecordWriter {

    private final BufferedWriter writer;
    private final File file;
    private boolean firstLoad = false;

    public CsvFileWriter(String fileName) throws IOException {
        this(new File(fileName));
        this.firstLoad = true;
    }

    public CsvFileWriter(File file) throws IOException {
        this.file = file;
        writer = new BufferedWriter(new FileWriter(file));
    }

    @Override
    public void write(Record record) {
        var line = new StringBuilder();

        Object[] values = record.getValues();
        String[] names = record.getNames();

        if (firstLoad) {
            line.append(String.join(",", names)).append("\n");
            firstLoad = false;
        }
        line.append(Arrays.stream(values)
                .map(Object::toString)
                .collect(Collectors.joining(",")));

        try {
            writer.write(line.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Problem writing file " + file.getAbsolutePath() + ".", e);
        }

    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
