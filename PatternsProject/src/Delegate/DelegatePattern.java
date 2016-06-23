package Delegate;

public class DelegatePattern {

	public static void main(String[] args) {
		 Painter p = new Painter();
	        p.setGraphics(new Triangle());
	        p.draw();
	        p.setGraphics(new Circle());
	        p.draw();
	}
}

interface Graphics {
	void draw();
}

class Triangle implements Graphics {

	@Override
	public void draw() {
		System.out.println("Draw triangle");
	}
}

class Square implements Graphics {

	@Override
	public void draw() {
		System.out.println("Draw square");
	}
}

class Circle implements Graphics {

	@Override
	public void draw() {
		System.out.println("Draw circle");
	}
}

class Painter {
	Graphics graphics;

	public void setGraphics(Graphics g) {
		graphics = g;
	}

	public void draw() {
		graphics.draw();
	}
}