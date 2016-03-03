package com.Threads;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
	
	private final BlockingQueue<Integer> queue;
	
	public Producer(BlockingQueue<Integer> q) {
		this.queue = q;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Produce" + i);
			try {
				queue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("exception");
				e.printStackTrace();
			}
		}
	}

}
