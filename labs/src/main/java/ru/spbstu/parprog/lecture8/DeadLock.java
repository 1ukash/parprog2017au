package ru.spbstu.parprog.lecture8;

import java.util.Random;

public class DeadLock {
	static int i = 0;

	public static void main(String[] args) {

		Object o1 = new Object();
		Object o2 = new Object();

		Random r = new Random();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {

					try {
						Thread.sleep(r.nextInt(100));
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}
					
					synchronized (o1) {
						try {
							Thread.sleep(r.nextInt(10));
						} catch (InterruptedException e) {
							e.printStackTrace();
							Thread.currentThread().interrupt();
						}
						synchronized (o2) {
							i++;
							System.out.println(Thread.currentThread().getName() + ": I am not blocked still " + i);
						}
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {

					try {
						Thread.sleep(r.nextInt(100));
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}
					
					synchronized (o2) {
						try {
							Thread.sleep(r.nextInt(10));
						} catch (InterruptedException e) {
							e.printStackTrace();
							Thread.currentThread().interrupt();
						}
						synchronized (o1) {
							i++;
							System.out.println(Thread.currentThread().getName() + ": I am not blocked still " + i);
						}
					}
				}
			}
		}).start();
	}

}
