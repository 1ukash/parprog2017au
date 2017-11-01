package ru.spbstu.parprog.lecture6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class ExceptionsExample {
	public static void main(String[] args) {

		checkedException();

		try {
			uncheckedException();
		} catch (RuntimeException e) {
			System.out.println(e);
		}

		try {
			myException();
		} catch (MyException e) {
			throw new DontKnowWhatToDoException("Magic happened", e);
		}

	}

	private static void myException() throws MyException {
		Random r = new Random();
		int a = r.nextInt();
		int b = r.nextInt();

		if (a > b) {
			throw new MyException();
		}

	}

	private static void uncheckedException() {

		Object obj = new Object();

		obj = null;

		try {
			obj.hashCode();
		} catch (RuntimeException e) {
			// e.printStackTrace();
			System.out.println("Oops! " + e.getMessage());
		}

		if (obj != null) {
			obj.toString();
		} else {
			throw new RuntimeException();
		}

	}

	private static void checkedException() {
		try {
			workWithFile();
			System.out.println("Everything is fine with our file");
		} catch (FileNotFoundException e) {
			// e.printStackTrace(); will never happen
			// for this programmer is going to hell
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Cleanup");
		}

		System.out.println("Continue to live");
	}

	private static void workWithFile() throws IOException {
		File f = new File("data.dat");
		FileOutputStream fos = new FileOutputStream(f);
		fos.close();
		fos.write(new byte[] { 1 });
	}
}
