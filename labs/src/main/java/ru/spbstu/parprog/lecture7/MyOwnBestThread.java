package ru.spbstu.parprog.lecture7;

import java.util.Date;

public class MyOwnBestThread implements Runnable {

	private SharedObject obj;

	public MyOwnBestThread(SharedObject obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		
		while (!Thread.currentThread().isInterrupted()) {
			
			System.out.println("Hi! I am a thread " + Thread.currentThread().getName());
			System.out.println("Now is " + new Date());
			
			obj.setCounter(obj.getCounter() + 1);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		
	}

}
