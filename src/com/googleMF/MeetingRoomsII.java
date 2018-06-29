package com.googleMF;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 *  Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find
 *  the minimum number of conference rooms required.
 *
 *  Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 *
 */
public class MeetingRoomsII {

    public static void main(String[] args) {
//        Interval i1 = new Interval(0,30);
//        Interval i2 = new Interval(5,10);
//        Interval i3 = new Interval(15,20);
//        Interval[] interval = new Interval[]{i1,i2,i3};

        Interval i2 = new Interval(7,10);
        Interval i3 = new Interval(2,4);
        Interval[] interval = new Interval[]{i2,i3};
        System.out.println(minMeetingRooms(interval));
    }

    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public static int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        int [] start = new int [len];
        int [] end = new int [len];
        for ( int i = 0; i < len; i++ ){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<len; i++) {
            if(start[i]<end[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;

    }

    //Makes more sense
    public int minMeetingRooms2(Interval[] intervals) {
        if(intervals==null||intervals.length==0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int count=1;
        queue.offer(intervals[0].end);

        for(int i=1; i<intervals.length; i++){
            if(intervals[i].start<queue.peek()){
                count++;

            }else{
                queue.poll();
            }

            queue.offer(intervals[i].end);
        }

        return count;
    }
}
