package com.rolfje.anonimatron.file;

public class Record {
    private final String[] names;
    private final Object[] values;

    public Record(String[] names, Object[] values) {
        if (names.length != values.length) {
            throw new IllegalArgumentException("Argument Arrays need to be the same size.");
        }
        this.names = names;
        this.values = values;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[Record: ");
        for (int i = 0; i < names.length; i++) {
            stringBuilder.append(names[i]);
            stringBuilder.append(":");

            if (values[i] != null) {
                stringBuilder.append("'").append(values[i].toString()).append("'");
            } else {
                stringBuilder.append("null");
            }

            if (i < names.length - 1) {
                stringBuilder.append(", ");
            }

        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public String[] getNames() {
        return names;
    }

    public Object[] getValues() {
        return values;
    }
}
