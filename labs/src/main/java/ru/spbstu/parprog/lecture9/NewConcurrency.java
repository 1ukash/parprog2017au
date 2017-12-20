package ru.spbstu.parprog.lecture9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NewConcurrency {
	
	static final Lock lock = new ReentrantLock();
	
	static final Object oldLock = new Object();
	
	public static void main(String[] args) {
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {
					
					try {
						lock.lock();
						// do synchronised things
					} finally {
						lock.unlock();
					}
					
					while(!lock.tryLock()) {
						//wait a bit
					}
					
					if (lock.tryLock()) {
						
					} else {
						
					}
					
//					synchronized (oldLock) {
//						
//					}
					
				}
				
			}
		}).start();

	}
}
