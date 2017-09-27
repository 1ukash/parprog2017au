package ru.spbstu.parprog.lecture3;

import ru.spbstu.parprog.FooBar;

public abstract class Shape implements Colored, Tasted {
	
	static int var = 100;
	
	static final FooBar f = new FooBar(1, "XYZ");
	
	private EventHappenedProcessor processor;
	
	public static class JustAClass {
		
	}
	
	public  class Point {
		protected int x,y = 1;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		void modifyFooBar() {
			f.setId(1);
		}
		
	}
	
	protected Point coords;
	
	
	static {
		var = 1000;
		
		f.setId(2);
	}

	public Shape(int x, int y) {
		super();
		this.coords =  new Point(x, y);
	}
	
	static int getVar() {
		return var;
	}

	
	public Point getCoords() {
		return coords;
	}

	public void setCoords(Point coords) {
		this.coords = coords;
	}

	abstract public String getName();

	public EventHappenedProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(EventHappenedProcessor processor) {
		this.processor = processor;
	}
}
