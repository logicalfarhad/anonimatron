package com.rolfje.anonimatron.file;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.*;
import java.util.List;

public class CsvFileReader implements RecordReader, Closeable {

    private final CSVParser records;
    private final Reader reader;

    public CsvFileReader(String fileName) throws IOException {
        try {
            reader = new FileReader(fileName);
            records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Problem while reading file .", e);
        }
    }


    @Override
    public List<CSVRecord> getRecordList() throws IOException {
        return records.getRecords();
    }

    @Override
    public List<String> getColumnNames() {
        return records.getHeaderNames();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
