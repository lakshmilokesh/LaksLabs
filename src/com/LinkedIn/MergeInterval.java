package com.LinkedIn;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * Given two arrays/Lists (choose whatever you want to) with sorted and non intersecting intervals. Merge them to get
 * a new sorted non intersecting array/list.
 *
 * Eg:
 * Given:
 * Arr1 = [3-11, 17-25, 58-73];
 * Arr2 = [6-18, 40-47];
 *
 * Wanted:
 * Arr3 = [3-25, 40-47, 58-73];
 */
public class MergeInterval {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();

        if(intervals==null||intervals.size()==0)
            return result;

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if(i1.start!=i2.start)
                    return i1.start-i2.start;
                else
                    return i1.end-i2.end;
            }
        });


        for (int i = 0; i< intervals.size(); i++) {
            System.out.println(intervals.get(i).start + "-" + intervals.get(i).end);
        }
        Interval pre = intervals.get(0);
        for(int i=0; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(curr.start>pre.end){
                result.add(pre);
                pre = curr;
            }else{
                Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
                pre = merged;
            }
        }
        result.add(pre);

        return result;
    }

    public static void main(String[] args) {
        List<Interval> arr1 = new ArrayList<>();
        arr1.add(new Interval(3,11));
        arr1.add(new Interval(17,25));
        arr1.add(new Interval(58,73));
        List<Interval> arr2 = new ArrayList<>();
        arr1.add(new Interval(6,18));
        arr1.add(new Interval(40,47));
        arr1.addAll(arr2);
        List<Interval> arr3 = merge(arr1);
        for (int i = 0; i< arr3.size(); i++) {
            System.out.println(arr3.get(i).start + "-" + arr3.get(i).end);
        }
    }

    static class Interval {
        int start;
        int end;
        Interval(int start, int end){
            this. start = start;
            this.end = end;
        }
    }


}
