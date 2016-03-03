package com.stacks;

public class ThreeStacks {
	int stacksize = 100;
	int[] buffer = new int[stacksize * 3];
	int[] pointers = new int[]{-1,-1,-1};
	
	public void push(int x, int stacknum) throws Exception {
		
		if (pointers[stacknum]+1 > stacksize)
			throw new Exception("Stack full");
		pointers[stacknum]++;
		buffer[absValue(stacknum)] = x;
		
	}
	
	public int pop(int stacknum) throws Exception {
		if (pointers[stacknum] == -1)
			throw new Exception("Stack empty");
		int val = buffer[absValue(stacknum)];
		buffer[absValue(stacknum)] = 0;
		pointers[stacknum]--;
		return val;
		
	}
	
	public int peek(int stacknum) throws Exception {
		if (pointers[stacknum] == -1)
			throw new Exception("Stack empty");
		return buffer[absValue(stacknum)];
	}

	private int absValue(int stacknum) {
		// TODO Auto-generated method stub
		return (stacknum * stacksize) + pointers[stacknum];
	}
}
