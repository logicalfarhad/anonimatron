package com.rolfje.anonimatron.file;

import java.util.List;

public class Record {
    private final List<String> names;
    private final List<Object> values;

    public Record(List<String> names, List<Object> values) {
        if (names.size() != values.size()) {
            throw new IllegalArgumentException("Argument Arrays need to be the same size.");
        }
        this.names = names;
        this.values = values;
    }
    public List<String> getNames() {
        return names;
    }

    public List<Object> getValues() {
        return values;
    }
}
