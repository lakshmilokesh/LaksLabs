package com.sorting;


/*
 * Car Parking problem
 * cost of computing hash for a complicated key might exceed cost searching for the key.
 *
 * Open addressing : when a new key collides, find the next empty slot and put it there.
 *
 * Map key to an integer between 0 - M-1
 * Put at table index i if free,if not try i+1, i+2
 *
 *
 */
public class LinearProbing {

    private int M = 30001;
    private Integer[] keys = (Integer[])new Object[M];
    private Integer[] values = (Integer[])new Object[M];

    public Object get(Object key) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i+1) % M ) {
            if (key == keys[i])
                return values[i];
        }
        return null;
    }

    public void put (Object key, Object value) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i+1) % M ) {
            if (key == keys[i])
                break;
        }
        keys[i] = (Integer)key;
        values[i] = (Integer)value;
    }

    private int hash(Object key) {
        return key.hashCode();
    }
}
