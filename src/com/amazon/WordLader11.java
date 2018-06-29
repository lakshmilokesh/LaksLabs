package com.amazon;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s)
 * from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 *  Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 */

import java.util.*;

public class WordLader11 {

    static HashMap<String, List<String>> map = new HashMap<>();
    static List<List<String>> res = new ArrayList<>();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");
        System.out.println(findLadders("hit", "cog", dict));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList.isEmpty())  return res;
        HashSet<String> set = new HashSet<>();
        HashSet<String> unvisited = new HashSet<>(wordList);
        set.add(beginWord);
        unvisited.remove(beginWord);
        boolean found = false;
        while(!set.isEmpty()){
            if(found)   break;
            HashSet<String> temp = new HashSet<>();
            for(String s: set){
                for(int i=0; i<s.length(); i++){
                    StringBuilder sb = new StringBuilder(s);
                    for(char c = 'a'; c<='z'; c++){
                        sb.setCharAt(i, c);
                        String newWord = sb.toString();
                        if(unvisited.contains(newWord)){
                            if(newWord.equals(endWord))
                                found=true;
                            temp.add(newWord);

                            //building the neighbour map
                            if(map.containsKey(newWord))
                                map.get(newWord).add(s);
                            else{
                                List<String> neighbours = new ArrayList<>();
                                neighbours.add(s);
                                map.put(newWord, neighbours);
                            }
                        }
                    }
                }
            }
            unvisited.removeAll(temp);
            set = temp;
        }

        backTrace(beginWord, endWord);
        return res;
    }

    private static void backTrace(String beginWord, String endWord){
        if(beginWord.equals(endWord)){
            list.add(0, beginWord);
            res.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        if(map.containsKey(endWord)){
            list.add(0, endWord);
            for(String pre: map.get(endWord)){
                backTrace(beginWord, pre);
            }
            list.remove(0);
        }
    }

}
