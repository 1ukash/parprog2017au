package ru.spbstu.parprog;
import java.util.Vector;

public class HelloWorld {

	public static void main (String[] args) {
		
		Vector<String> v = new Vector<>();
		v.add("First one");
		System.out.println("Hello world from eclipse");
		// new comment here
		System.out.println(v);
		
		
		int a = 10;
		// int,byte, float, double, ...
		Integer x = 10;
		Integer y = new Integer(100);
		a = x + y;
		
		String abc = "abc";
		Object obj = new Object();
		
		FooBar fooBar = new FooBar(10, "Alex");
		System.out.println(fooBar.concatenate());
		
	}

}
