package com.amazon.log;

import java.util.Arrays;

public class Log {
    private String id;
    private String value;

    public Log(String[] values) {
        this.id = values[0];
        this.value = String.join(",", Arrays.copyOfRange(values, 1, values.length));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return id + "," + value;
    }
}
