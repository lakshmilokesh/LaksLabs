package com.Threads;

import java.util.concurrent.BlockingQueue;


public class Consumer extends Thread{
	
	private final BlockingQueue<Integer> queue;
	
	public Consumer(BlockingQueue<Integer> q) {
		this.queue = q;
	}

	public void run() {
		while(true) {
			try {
				System.out.println("take" + queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception");
				e.printStackTrace();
			}
		}
	}
	


}
