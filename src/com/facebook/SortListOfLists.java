package com.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of n sorted lists of numbers, write a method that returns one giant list of all the numbers in order.
 *
 * NSArray* input = @[
 * @[@2, @5, @10],
 * @[@25, @100, @105],
 * @[@7, @56, @42],
 * .......
 * ];
 */
public class SortListOfLists {

    public static void main(String[] args) {

        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(10);
        finalList.add(list);
        list = new ArrayList<>();
        list.add(25);
        list.add(100);
        list.add(105);
        finalList.add(list);
        list = new ArrayList<>();
        list.add(7);
        list.add(56);
        list.add(42);
        finalList.add(list);

        List<Integer> result = sort(finalList);
        System.out.println(result);

    }
    public static List<Integer> sort(List<List<Integer>> list) {
        List<Integer> finalList = new ArrayList<Integer>();
        int begin = 0, end = list.size()-1;
        while (end > 0) {
            begin = 0;
            while (begin < end) {
                list.set(begin,mergeTwoList(list.get(begin),list.get(end)));
                begin++;
                end--;
            }
        }
        return list.get(0);
    }

    private static List<Integer> mergeTwoList(List<Integer> list1, List<Integer> list2) {
        int i = 0,j=0;
        List<Integer> result = new ArrayList<>();
        while (list1 != null && list2 != null && i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i));
                i++;
            }
            else {
                result.add(list2.get(j));
                j++;
            }

        }
        while (list1 != null && list1.size() > i) {
            result.add(list1.get(i));
            i++;
        }
        while (list2 != null && list2.size() > j) {
            result.add(list2.get(j));
            j++;
        }
        return result;
    }

}
