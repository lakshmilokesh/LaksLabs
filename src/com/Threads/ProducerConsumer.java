package com.Threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
		
		Thread prod = new Thread(new Producer(sharedQueue));
		Thread cons = new Thread(new Consumer(sharedQueue));
		prod.start();
		cons.start();
		
	}

}
