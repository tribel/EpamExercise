package TemplateMethod;

public class Template {

	public static void main(String[] args) {
		AbstractClass ob = new A();
		ob.templateMethod();
		
		AbstractClass ob1  = new B();
		ob1.templateMethod();
	}
}


abstract class AbstractClass {
	
	public void templateMethod() {
		System.out.println("First message");
		metod1();
		System.out.println("Third message");
		method2();
	}
	
	abstract void metod1();
	abstract void method2();
}


class A extends AbstractClass {

	@Override
	void metod1() {
		System.out.println("Second message ");
	}

	@Override
	void method2() {
		System.out.println("Fifth message");
	}
	
}


class B extends AbstractClass {

	@Override
	void metod1() {
		System.out.println("Foth message");
	}

	@Override
	void method2() {
		
	}
	
}