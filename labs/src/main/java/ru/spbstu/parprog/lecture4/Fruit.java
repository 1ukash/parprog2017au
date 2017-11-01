package ru.spbstu.parprog.lecture4;

import java.util.Date;

public class Fruit implements Cloneable{

	static enum Type {
		APPLE, ORANGE, PINEAPPLE
	}

	private Type type;
	private int id;
	private Date issueDate;
	private Bag bag;

	public Fruit() {
	}
	
	

	public Fruit(Type type, int id, Date issueDate) {
		super();
		this.type = type;
		this.id = id;
		this.issueDate = issueDate;
	}

	public Bag getBag() {
		return bag;
	}

	public void setBag(Bag bag) {
		this.bag = bag;
	}



	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	@Override
	public Fruit clone() throws CloneNotSupportedException {
		Fruit copy = (Fruit) super.clone();
		copy.setBag(bag.clone());
		return copy;
	}
	
	private void createFullCopy() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return "I am a Fruit! Fruit with type " + type + " and has a link " + super.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		Fruit obj2 = (Fruit) obj;
		return this.id == obj2.id && this.issueDate.equals(obj2.issueDate);
	}
	
	@Override
	public int hashCode() {
		return issueDate.hashCode() + id;
	}

}
