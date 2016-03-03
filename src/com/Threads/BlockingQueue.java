package com.Threads;

import java.util.List;

import com.linked.list.LinkedList;

public class BlockingQueue {
	
	private List<Integer> queue = (List<Integer>) new LinkedList();
	
	private int limit = 10;
	
	public BlockingQueue(int limit) {
		this.limit = limit;
	}   
	
	public synchronized void enqueue(Integer i) throws InterruptedException {
		while(this.queue.size() ==this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(i);
	}
	
	public synchronized void dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}
		this.queue.remove(0);
	}

}
