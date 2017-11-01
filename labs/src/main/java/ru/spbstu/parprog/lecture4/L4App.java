package ru.spbstu.parprog.lecture4;

import java.util.Date;

import ru.spbstu.parprog.lecture4.Fruit.Type;

public class L4App {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date d = new Date();
		System.out.println(d);
		
		Fruit f = new Fruit(Type.APPLE, 1, d);
		f.setBag(new Bag());
		
		System.out.println(f + " is a link to object");
		System.out.println(f.getBag() + " is a link to Bag");
		System.out.println();
		
		Fruit f2 = processFruit(f.clone());
		
		if (f.equals(f2)) {
			System.out.println("Fruits are equal");
		} else {
			System.out.println("Fruits are NOT equal");	
		}
		
		String s1 = "Baggage";
		String tmp = s1;
		s1 = s1 + "!";
		
		System.out.println(s1 == tmp);
		
		String s3 = "I am a bot";
		String s4 = "I am a bot";
		
		System.out.println(s3.equals(s4));
		
		Integer i = 50;
		Integer j = 50;
		
		System.out.println(i == j);
		
		i = 500;
		j = 500;
		System.out.println(i == j);
	}

	private static Fruit processFruit(Fruit f) {
		System.out.println(f + " is a link to object in a process() method");
		System.out.println(f.getBag() + " is a link to Bag");
		
		return f;
	}
}
