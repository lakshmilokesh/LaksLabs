package com.faq;

public class HashEntry {
	
	private int key;
	private int value;
	
	HashEntry(int key, int value) {
		this.key = key;
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getKey() {
		return this.key;
	}

}
