package com.rolfje.anonimatron.file;

import org.apache.commons.csv.CSVRecord;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Provides records to be anonymized the {@link FileAnonymizerService}.
 */
public interface RecordReader extends Closeable{
	List<CSVRecord> getRecordList() throws IOException;
    List<String> getColumnNames();
}
