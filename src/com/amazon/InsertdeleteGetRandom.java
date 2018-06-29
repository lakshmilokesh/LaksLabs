package com.amazon;

/*
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being
 * returned.
 *
 *
 */

import java.util.*;

public class InsertdeleteGetRandom {


    class RandomizedSet {

        Map<Integer,Integer> map;
        List<Integer> list;
        Random random = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {

            if (map.containsKey(val))
                return false;
            map.put(val,list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {

            if(!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            if (index < list.size()-1) {
                int lastItem = list.get(list.size() - 1);
                list.set(index, lastItem);
                map.put(lastItem, index);
            }
                list.remove(list.size()-1);
                map.remove(val);
            return true;
            }
        /** Get a random element from the set. */
        public int getRandom() {
            return map.get(random.nextInt(list.size()));
        }

        }


    }

