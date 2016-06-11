package composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {

	public static void main(String[] args) {
		Shape square1 = new Square();
		Shape square2 = new Square();
		Shape square3 = new Square();
		Shape triangle1 = new Triangle();
		Shape circle1 = new Circle();
		Shape circle2 = new Circle();
		Shape circle3 = new Circle();
		
		Composite composite = new Composite();
		Composite composite1 = new Composite();
		Composite composite2 = new Composite();
		
		composite1.addComponent(square1);
		composite1.addComponent(circle1);
		composite1.addComponent(triangle1);
		
		composite2.addComponent(square3);
		composite2.addComponent(circle1);
		composite2.addComponent(circle2);
		composite2.addComponent(circle3);
		
		
		composite.addComponent(composite1);
		composite.addComponent(composite2);
	
		composite.draw();
	}
	
}


interface Shape {
	
	void draw();
}


class Triangle implements Shape {

	@Override
	public void draw() {
		System.out.println("I am Triangle");
	}
	
}


class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("I am Square");
	}
	
}


class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("I am Circle");
	}
	
}

class Composite implements Shape {

	private List<Shape> components = new ArrayList<>();
	
	public void addComponent(Shape comp) {
		components.add(comp);
	}
	
	public void removeComponent(Shape comp) {
		components.remove(comp);
	}
	
	@Override
	public void draw() {
		for(Shape c: components) {
			c.draw();
		}
	}
	
}
