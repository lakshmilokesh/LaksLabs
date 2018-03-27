package com.facebook;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Write a function to find how many valid letters are in a string of digits given the mapping:
 * a -> 1
 * b -> 2
 * ...
 * z - > 26
 *
 * ex) 123 =>1, 12, 23 => a, l, w
 * abc
 * aw
 * lc
 *
 * For example:
 * Input: "1123". You need to general all valid alphabet codes from this string.
 *
 * Output List
 * aabc //a = 1, a = 1, b = 2, c = 3
 * kbc // since k is 11, b = 2, c= 3
 * alc // a = 1, l = 12, c = 3
 * aaw // a= 1, a =1, w= 23
 * kw // k = 11, w = 23
 *
 */
public class LettersDigitsMapping {


    public static void main(String[] args) {

//        // Iterative approach
//         List<String> codes = findAllCodes("123");
//
//        System.out.println(codes.size());
//        for (String code : codes){
//            System.out.println(code);
//        }
//
        Set<String> codes = decode("","123");
        for (String code : codes){
            System.out.println(code);
        }
    }

    //Recursive approach
    public static Set<String> decode(String prefix, String code) {
        Set<String> set = new HashSet<String>();
        if (code.length() == 0) {
            set.add(prefix);
            return set;
        }

        if (code.charAt(0) == '0')
            return set;

            set.addAll(decode(prefix + (char) (code.charAt(0) - '1' + 'a'),
                    code.substring(1)));
            if (code.length() >= 2 && code.charAt(0) == '1') {
                char m = (char) (10 + code.charAt(1) - '1' + 'a');
                set.addAll(decode(
                        prefix + (char) (10 + code.charAt(1) - '1' + 'a'),
                        code.substring(2)));
            }
            if (code.length() >= 2 && code.charAt(0) == '2'
                    && code.charAt(1) <= '6') {
                set.addAll(decode(
                        prefix + (char) (20 + code.charAt(1) - '1' + 'a'),
                        code.substring(2)));
            }
        return set;
    }

    // Iterative approach
    private static List<String> findAllCodes(String string) {


        List<String> ret = new ArrayList<String>();
        List<String> preRet = new ArrayList<String>();

        for (int index = 0; index < string.length(); index ++){
            List<String> temp1 = new ArrayList<String>();
            List<String> temp2 = new ArrayList<String>();
            if (index >=  1){
                int val = Integer.valueOf(string.substring(index - 1, index + 1));
                if (val <= 26 && val >= 10){
                    char chr = (char)(val + 96);
                    temp1 = addChrToPrefix(preRet, chr);
                }
            }
            int val = Integer.valueOf(string.substring(index, index + 1));
            if (val != 0){
                char chr = (char)(val + 96);
                temp2  = addChrToPrefix(ret, chr);
            }
            preRet = ret;
            temp1.addAll(temp2);
            ret = temp1;
        }
        return ret;
    }



    private static List<String> addChrToPrefix(List<String> preRet, char chr) {

        List<String> ret = new ArrayList<String>();
        if (preRet.size() == 0){
            ret.add(String.valueOf(chr));
        }
        for (String item : preRet){
            ret.add(item + String.valueOf(chr));
        }
        return ret;
    }
}
