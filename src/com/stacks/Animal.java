package com.stacks;

public abstract class Animal {
	
	String name;
	int order;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public int getOrder() {
		return this.order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public boolean isOlderThan(Animal a) {
		return this.order < a.order;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
