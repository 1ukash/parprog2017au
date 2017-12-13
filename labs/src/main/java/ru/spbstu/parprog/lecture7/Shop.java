package ru.spbstu.parprog.lecture7;

import java.util.LinkedList;
import java.util.List;

public class Shop {

	private static final int PRODUCT_PRICE = 1;
	private static final int CNT = 8;
	private static final int START_CAPITAL = 50000000;

	private static class Buyer implements Runnable {
		private int money = START_CAPITAL;
		private Seller s;

		public Buyer(Seller s) {
			this.s = s;
		}

		@Override
		public void run() {
			while (money >= s.getPrice() && s.getCnt() > 0 && !Thread.currentThread().isInterrupted()) {
				synchronized (s) {
					if (money >= s.getPrice() && s.getCnt() > 0) {
						s.setCnt(s.getCnt() - 1);
						this.money -= s.getPrice();
						s.setMoney(s.getMoney() + s.getPrice());
					}
				}
			}
		}

	}

	private static class Seller {
		private long price = PRODUCT_PRICE;
		private long cnt = 100000000;
		private long money = 0;

		public long getPrice() {
			return price;
		}

		public void setPrice(long price) {
			this.price = price;
		}

		public long getCnt() {
			return cnt;
		}

		public void setCnt(long cnt) {
			this.cnt = cnt;
		}

		public long getMoney() {
			return money;
		}

		public void setMoney(long money) {
			this.money = money;
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Seller s = new Seller();
		List<Thread> l = new LinkedList<>();
		List<Buyer> n = new LinkedList<>();

		System.out.println(CNT * START_CAPITAL);

		for (int i = 0; i < CNT; i++) {
			Buyer b = new Buyer(s);
			Thread t = new Thread(b);
			n.add(b);
			l.add(t);
			t.start();
		}

		for (Thread t : l) {
			t.join();
		}

		long sum = s.money;

		for (Buyer b : n) {
			sum += b.money;
		}

		System.out.println(sum);

	}

}
