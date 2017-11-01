package ru.spbstu.parprog.lecture6;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOExample {
	public static void main(String[] args) throws IOException {
		
		write();
		
		read();
		
	}

	private static void read() throws IOException {
		FileInputStream fis = new FileInputStream(new File("example.dat"));
		DataInputStream dis = new DataInputStream(fis);
		System.out.println(dis.readUTF());
		System.out.println(dis.readInt());
		System.out.println(dis.readDouble());
		dis.close();
	}

	private static void write() throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream(new File("example.dat"));
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		dos.writeUTF("It is a string\n");
		dos.writeInt(10);
		dos.writeDouble(0.123145);
		dos.flush();
		dos.close();
	}
}
