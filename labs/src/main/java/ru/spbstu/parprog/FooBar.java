package ru.spbstu.parprog;

public class FooBar {

	private int id = 1;
	private String name = "Jonnie";
	
	public FooBar(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public FooBar() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String concatenate() {
		return id + name;
	}
}
