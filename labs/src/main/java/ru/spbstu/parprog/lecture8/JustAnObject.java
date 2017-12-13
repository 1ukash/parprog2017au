package ru.spbstu.parprog.lecture8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class JustAnObject {

	private int state1;
	private String state2;

	public synchronized int getState1() {
		return state1;
	}

	public synchronized void setState1(int state1) {
		this.state1 = state1;
	}

	public synchronized String getState2() {
		return state2;
	}

	public synchronized void setState2(String state2) {
		this.state2 = state2;
	}

	public synchronized void changeState() {
		state1++;
	}

	private void foo() {

		Vector<String> v = new Vector<>();
		List<String> l = new ArrayList<>();
		
		l = Collections.synchronizedList(l);

	}
}
