package com.faq;

public class HashMap {

	private static final int TABLESIZE = 128;
	private HashEntry[] table;
	
	HashMap() {
		table = new HashEntry[TABLESIZE];
		for (int i = 0; i < TABLESIZE; i++) {
			table[i] = null;
		}
	}
	
	public int get(int key) {
		int hash = key%TABLESIZE;
		while (table[hash] != null && table[hash].getKey() != key) {
			hash = (hash + 1) % TABLESIZE;
		}
		if (table[hash] == null)
			return -1;
		
		return table[hash].getValue();
	}
	
	public void put(int key, int value) {
		int hash = key%TABLESIZE;
		while (table[hash] != null && table[hash].getKey() != key) {
			hash = (hash+1)%TABLESIZE;
		}
		table[hash] = new HashEntry(key, value);
	}

}
