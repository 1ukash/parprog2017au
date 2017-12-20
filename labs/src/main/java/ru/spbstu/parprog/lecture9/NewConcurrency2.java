package ru.spbstu.parprog.lecture9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NewConcurrency2 {
	
	static final ReadWriteLock lock = new ReentrantReadWriteLock();
	
	
	public static void main(String[] args) {
		
		
		Runnable reader = new Runnable() {
			
			@Override
			public void run() {
				Lock readLock = lock.readLock();
				while(!Thread.currentThread().isInterrupted()) {
					
					try {
						readLock.lock();
						// do synchronised things
					} finally {
						readLock.unlock();
					}
				}
				
			}
		};
		Runnable writer = new Runnable() {
			
			@Override
			public void run() {
				Lock writeLock = lock.writeLock();
				while(!Thread.currentThread().isInterrupted()) {
					
					try {
						writeLock.lock();
						// do synchronised things
					} finally {
						writeLock.unlock();
					}
				}
				
			}
		};

		new Thread(reader).start();
		new Thread(writer).start();

	}
}
