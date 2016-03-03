package com.Threads;

/**
 * Created by Laks on 2/21/16.
 *
 * The while loop is called spin lock
 */
public class Lock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException{
        while(isLocked){
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}
