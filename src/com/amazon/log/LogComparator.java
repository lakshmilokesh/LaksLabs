package com.amazon.log;


import java.util.Comparator;

public class LogComparator implements Comparator<Log> {

    @Override
    public int compare(Log o1, Log o2) {

        boolean flag1 = o1.getValue().matches(".*\\d+.*");
        boolean flag2 = o2.getValue().matches(".*\\d+.*");

        if (flag1 && flag2) {
            return 0;
        }

        if (flag1) return 1;

        if (flag2) return -1;

        int val = o1.getValue().compareTo(o2.getValue());
        return val == 0 ? o1.getId().compareTo(o2.getId()) : val;
    }
}