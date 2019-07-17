package com.amazon.log;

import java.util.List;

/*
 * Amazon 2018
 * Input : List<String[]> , logfilesize (int)
 *
 * [<identifier>, <list of words> or <list of numbers>]
 *
 * [wqz, abc,tre,wwe,ff]
 * [red,45,43,44,55]
 * [gfd,abc,rrr,ee,ffv]
 * [hju,56,78,65,34]
 * [aaa, abc,tre,wwe,ff]
 *
 * Output :
 *
 * [aaa, abc,tre,wwe,ff]
 * [wqz, abc,tre,wwe,ff]
 * [gfd,abc,rrr,ee,ffv]
 * [red,45,43,44,55]
 * [hju,56,78,65,34]
 *
 */

import java.util.ArrayList;

public class SortingLogFile {

    public static void main(String[] args) {

        List<String[]> inputList = new ArrayList<String[]>();

        String[] s1 = new String[] {"bbb","abc","tre","wwe","ff"};
        String[] s2 = new String[] {"red","67","98","44","678"};
        String[] s6 = new String[] {"red","69","98","44","678"};
        String[] s3 = new String[] {"gfd","abc","rrr","iuy","oo"};
        String[] s4 = new String[] {"hju","11","984","99","87"};
        String[] s5 = new String[] {"aaa","abc","tre","wwe","ff"};

        inputList.add(s1);
        inputList.add(s2);
        inputList.add(s3);
        inputList.add(s4);
        inputList.add(s5);
        inputList.add(s6);

        List<Log> logList = convertToLog(inputList);

        logList.sort(new LogComparator());

        for (Log l:logList) System.out.println(l.toString());

    }

    private static List<Log> convertToLog(List<String[]> arrayStringList) {

        List<Log> logList = new ArrayList<>();

        for (String[] arrayString: arrayStringList) {
            Log log = new Log(arrayString);
            logList.add(log);
        }

        return logList;
    }
}
