package com.Threads;

/**
 * Created by Laks on 2/21/16.
 *
 * Additionally, we need to count the number of times the lock has been locked by the same thread. Otherwise, a single
 * call to unlock() will unlock the lock, even if the lock has been locked multiple times. We don't want the lock to be
 * unlocked until the thread that locked it, has executed the same amount of unlock() calls as lock() calls.
 *
 */
public class ReentrantLock {

    boolean isLocked = false;
    Thread  lockedBy = null;
    int     lockedCount = 0;

    public synchronized void lock()
            throws InterruptedException{
        Thread callingThread = Thread.currentThread();
        while(isLocked && lockedBy != callingThread){
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = callingThread;
    }


    public synchronized void unlock(){
        if(Thread.currentThread() == this.lockedBy){
            lockedCount--;

            if(lockedCount == 0){
                isLocked = false;
                notify();
            }
        }
    }

}
