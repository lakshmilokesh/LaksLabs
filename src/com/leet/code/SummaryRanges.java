package com.leet.code;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Laks on 2/3/16.
 *
 */
public class SummaryRanges {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,4,5,7,8,9};
        System.out.println("Ranges");
        System.out.println(summaryRanges(arr));
    }

    public static List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int j = nums[0];

        int i = 1;
        int start = 0;
        while (i <= nums.length) {
            start  = nums[i-1];
            j = nums[i-1];
            while (i < nums.length && nums[i] == ++j)i++;
            if (start != nums[i-1])
                result.add(start + "->" + nums[i-1]);
            else
                result.add(""+start);
            i++;

        }

        return result;
    }
}
