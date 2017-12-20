package ru.spbstu.parprog.lecture9;

public class RendezvousObject {

	private String state;
	private String result;

	String publish(String s) throws InterruptedException {
		
		synchronized (this) {
			this.state = s;
			notify();
		}

		while (result == null) {
			synchronized (this) {
				wait();
			}
		}

		return result;
	}

	void process() throws InterruptedException {
		while (state == null) {
			synchronized (this) {
				wait();
			}
		}
		
		result = state + state;
		
		synchronized (this) {
			notify();
		}
	}

}
