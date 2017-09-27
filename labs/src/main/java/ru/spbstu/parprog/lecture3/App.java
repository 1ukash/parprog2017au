package ru.spbstu.parprog.lecture3;

import ru.spbstu.parprog.lecture3.Shape.JustAClass;
import ru.spbstu.parprog.lecture3.Shape.Point;

public class App {
	public static void main(String[] args) {
		doMagic();
		
		doMagicAgain();
	}

	private static void doMagicAgain() {
		Shape c = new Circle(1, 1, 1000);
		c.setProcessor(new EventHappenedProcessor() {
			
			@Override
			public void onPressed() {
				System.out.println("Hey! You pressed me!");
			}
			
			@Override
			public void onClick() {
				System.out.println("I don't like when you click me!");				
			}
		});
		
		Shape d = new Triangle(10, 12);
		d.setProcessor(new TriangleEventHappenedProcessor());
	}

	private static void doMagic() {
		Circle p = new Circle(1, 1, 10);
		Square s = new Square(0, 0, 10, 10);
		
		Point pp = p.new Point(1,1);
		JustAClass jac = new JustAClass();

		Class pClazz = p.getClass();
		System.out.println(pClazz.getName());
		System.out.println(s.getClass().getName());
		if (p instanceof Shape) {
			System.out.println("p is Shape");
		}

		if (s instanceof Shape) {
			System.out.println("s is Shape");
		}

		if (s.getClass() == Square.class) {
			System.out.println("s is Shape");
		}

		// p = s;

		if (p instanceof Circle) {
			System.out.println("p is Circle");
		}

		s.getWidth();
		
		class Container {
			int a, b, c;
		}

		// ((Circle) p).getRadius();

		System.out.println(p.getName());
		System.out.println(s.getName());

		Colored c = getColoredShape();
		c.getColor();
		System.out.println(c.getClass().getName());
	}

	static Colored getColoredShape() {
		return new Circle(1, 1, 100);
	}
}
