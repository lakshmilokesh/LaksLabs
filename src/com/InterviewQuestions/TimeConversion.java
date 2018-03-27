package com.InterviewQuestions;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * Created by Laks on 2/16/16.
 *
 * Sample question practised for Pure Storage code interview
 *
 * CONVERT TO 24 HOUR CLOCK
 * 03:00:PM 15:00
 *
 */
public class TimeConversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        String[] timeSplit = time.split(":");
        System.out.println(time);
        if (time.toUpperCase().contains("PM")) {
            int hour = Integer.parseInt(timeSplit[0]) + 12;
            timeSplit[0] = ""+hour;
        }
        else {
            if (timeSplit[0].equals("12")) {
                timeSplit[0] = "00";
            }
        }
        timeSplit[2] = timeSplit[2].substring(0,2);
        System.out.print(timeSplit[0]+":"+timeSplit[1]);
    }
}

