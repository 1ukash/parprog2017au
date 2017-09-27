package ru.spbstu.parprog.lecture3;

public class Square extends Shape{

	private int length, width;
	
	public Square(int x, int y, int length, int width) {
		super(x, y);
		this.length = length;
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String getName() {
		return "Square";
	}

	@Override
	public int getColor() {
		return RED;
	}
	
}
