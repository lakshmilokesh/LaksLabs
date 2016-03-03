package com.Threads;

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
