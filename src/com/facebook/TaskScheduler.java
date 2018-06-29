package com.facebook;

import java.util.Arrays;

/*
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters
 * represent different tasks.Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n
 * intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 *
 * Note:
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 *
 */

public class TaskScheduler {

    public static void main(String[] args) {

        char[] tasks = new char[] {'A','B','A','A','B','B'};
        System.out.println(leastInterval(tasks,2));
    }

    public static int leastInterval(char[] tasks, int n) {

        // map - to track the occurrence of the alphabets map[0] -> A, map[1] -> B
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;

        //Sorting map to track the occurrence of the alphabets in order.
        //map[25] will have the alphabet with max number of occurrence. in the example it will be A
        Arrays.sort(map);

        //time tracks the mininmum intervals needed to complete the job
        int time = 0;

        //After sorting if map[25] = 0 then we stop as there are no more task to process
        while (map[25] > 0) {
            int i = 0;

            //continue untill i is less than or equal to cooling time
            while (i <= n) {
                //if map[25] = 0 then we stop as there are no more task to process
                if (map[25] == 0)
                    break;

                //processing from end of array, ie task occurrence in decreasing order
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            //sort each time after you reaching the cooling time
            Arrays.sort(map);
        }
        return time;

    }


}
