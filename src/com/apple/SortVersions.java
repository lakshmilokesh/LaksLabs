package com.apple;

import java.util.*;

/*
 * Apple March 2018 - QE Interview
 */

public class SortVersions {

    public static void main(String[] args) {

        List<String> versions = new ArrayList<>();
        versions.add("1.0.1");
        versions.add("1.1.2");
        versions.add("1");
        versions.add("1.0.0");
        List<String> result = compareVersions(versions);

        for(String s : result) {
            System.out.println(s);
        }

    }


    public static List<String> compareVersions(List<String> versions)
    {

        Collections.sort(versions, new Comparator<String>() {
            @Override
            public int compare(String version1, String version2) {
                String[] levels1 = version1.split("\\.");
                String[] levels2 = version2.split("\\.");

                int length = Math.max(levels1.length, levels2.length);
                for(int i = 0; i<length;i++)
                {
                    Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
                    Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
                    int compare = v1.compareTo(v2);
                    if (compare != 0)
                        return compare;
                }
                return 0;
            }
        });

        return versions;

    }
}
