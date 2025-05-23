package logics;

	class A{
		int a = 20;
	}
	class B extends A{
		int b = 30;

		
	}
	class C extends B{
		
		int c = 40;
	}
	
	public class ClassCastExceptiom {
	public static void main(String[] args) {
		A a = new B();           //auto upcasted
		System.out.println("1");
		B b = (B) a;             // down upcasted
		System.out.println("2");
		A a1= new A();          //no 
		System.out.println("3");
		C c = (C) b;
		System.out.println("4");
		

	}

}
