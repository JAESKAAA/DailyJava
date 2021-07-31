package Interface;

interface I {
	public abstract void method (I i); //인터페이스 I를 구현한 클래스만 들어오시게
	public String toString();
}

class A implements I{
	public void method(I i) {
		System.out.println("나는 클래스"+i+"다");
	}
	public String toString() {
		return "A";
	}
}

class B implements I{
	public void method(I i) {
		System.out.println("나는 메서드 비다");
	}
	public String toString() {
		return "B";
	}
	
}

class C implements I{
	public void method(I i) {
		System.out.println("나는 메서드 씨다)");
	}
	public String toString() {
		return "C";
	}

}


public class InterfaceTest {

	public static void main(String[] args) {

		I a = new A();
		
		a.method(new C());
		
	}

}
