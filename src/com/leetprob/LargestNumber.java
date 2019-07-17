package com.leetprob;


import java.util.Arrays;
import java.util.Comparator;

/*
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * Time complexity : O(nlgn)
 * Although we are doing extra work in our comparator, it is only by a constant factor. Therefore, the overall runtime
 * is dominated by the complexity of sort, which is \mathcal{O}(nlgn)O(nlgn) in Python and Java.
 *
 * Space complexity : O(n)
 * Here, we allocate \mathcal{O}(n)O(n) additional space to store the copy of nums. Although we could do that work in
 * place (if we decide that it is okay to modify nums), we must allocate \mathcal{O}(n)O(n) space for the final return
 * string. Therefore, the overall memory footprint is linear in the length of nums.
 *
 *
 */
public class LargestNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{3,30,34,5,9};
        String largestNum = largestNumber(arr);
        System.out.println("Largest Number -> " + largestNum);
    }

    public static String largestNumber(int[] nums) {

        StringBuffer largestNumber = new StringBuffer();
        String[] numbers = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("-->" + o1+o2 + "===> " + o2+o1);
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if (numbers[0].compareTo("0") == 0){
            return String.valueOf(0);
        }

        for (String str : numbers){
            largestNumber.append(str);
        }
        return largestNumber.toString();
    }
}
