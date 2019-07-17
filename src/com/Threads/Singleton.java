package com.Threads;

/*
 * http://tutorials.jenkov.com/java-concurrency/volatile.html
 *
 * The Java volatile keyword is used to mark a Java variable as "being stored in main memory". More precisely that means,
 * that every read of a volatile variable will be read from the computer's main memory, and not from the CPU cache, and
 * that every write to a volatile variable will be written to main memory, and not just to the CPU cache.
 *
 *
 */
class Singleton {

	private static volatile Singleton instance = null;

    private Singleton() {
        
    }
    
	public static Singleton getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			synchronized(Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;

	}

}
