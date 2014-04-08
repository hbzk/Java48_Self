package basic.exam06.jdbc;

interface T {
	
}

class A {
	
}

class B extends A implements T {
	
}

class C extends B {
	
}

public class Episode01 {
	
	public static void main(String[] args) {
		T t;
		A a = new A();
		B b = new B();
		C c  = new C();
		
		B b2 = c;
		A a2 = c;
		T t2 = c; 	// > c는 구현체(B)를 상속 받았기 때문에 가능
		// > ==> (T에) 선언된 메서드를 모두 호출 가능한 경우, 다른 객체의 주소를 저장 할 수 있다
		
		// C c3 = b;
		A a3 = b;
		T t3 = b;
		
		// T t4 = a;
	}
}
