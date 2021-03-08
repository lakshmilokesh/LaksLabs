package com.GoogleMF2019;

import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;

/*
 * Create a timebased key-value store class TimeMap, that supports two operations.

1. set(string key, string value, int timestamp)

Stores the key and value, along with the given timestamp.
2. get(string key, int timestamp)

Returns a value such that set(key, value, timestamp_prev) was a2called previously, with timestamp_prev <= timestamp.
If there are multiple such values, it returns the one with the largest timestamp_prev.
If there are no values, it returns the empty string ("").
 *
 *
 */


    public class TimeBasedKeyValueStore {
        Map<String, TreeMap<Integer, String>> M;

        public TimeBasedKeyValueStore() {
            M = new HashMap();
        }

        public void set(String key, String value, int timestamp) {
            if (!M.containsKey(key))
                M.put(key, new TreeMap());

            M.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!M.containsKey(key)) return "";

            TreeMap<Integer, String> tree = M.get(key);
            Integer t = tree.floorKey(timestamp);
            return t != null ? tree.get(t) : "";
        }
    }

