package ru.spbstu.parprog.lecture9;

import java.util.ArrayList;

public class BlockingQueue<T> {
	
	private int capacity;
	
	private ArrayList<T> elements = new ArrayList<>(); 
	
	void put(T obj) throws InterruptedException {
		
		synchronized (this) {
			while (capacity <= elements.size()) {
				wait();
			}
			elements.add(obj);
			notifyAll();
		}
		
		
	}
	
	T get() throws InterruptedException {
		
		T rem = null;
		synchronized (this) {
			while (elements.isEmpty()) {
				wait();
			}
			rem = elements.remove(0);
			notifyAll();
		}
		return rem;
		
	}

}
