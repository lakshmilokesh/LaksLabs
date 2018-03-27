package com.InterviewQuestions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by Laks on 2/22/16.
 */
public class TraverseMap {

    public static void main(String[] args) {
        Map<String,String> map= new HashMap<String,String>();
        map.put("Laks","me");
        map.put("Lokee","sh");
        printMap(map);
    }

    public static void printMap(Map<String,String> mp) {

        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            //System.out.println(pair.getKey() + " = " + pair.getValue());
           // it.remove(); // avoids a ConcurrentModificationException
        }

        for (Map.Entry val : mp.entrySet()) {
            System.out.println(val.getKey() + "=" + val.getValue());
        }
    }
}
