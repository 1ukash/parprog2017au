package ru.spbstu.parprog.lecture7;

public class ThreadExample {
	public static void main(String[] args) throws InterruptedException {
		
		SharedObject obj = new SharedObject();
		
		System.out.println("Hey there! I am main thread: " + Thread.currentThread().getName());
		
		Thread t = new Thread(new MyOwnBestThread(obj), "GreatThread");
		
		t.start();
		
		System.out.println(Thread.currentThread().getName() + " joined!");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("I was created just to print this stupid line and die");
			}
		}).start();
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " is also printing nice output and obj=" + obj.getCounter());
			Thread.sleep(2000);
		}
		t.interrupt();
		
//		t.stop();
		
		Thread.sleep(5000);

	}
}
