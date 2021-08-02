package innerClass;

class Outer {
	class InstanceInner {
		int iv = 100;
	}
	
	static class StaticInner {
		int iv = 200;
		static int cv = 300;
	}
	
	void myMethod () {
		class LocalInner {
			int iv =400;
		}
	}
}

public class innerClass {

	public static void main(String[] args) {
		Outer a = new Outer(); //외부 클래스를 먼저 생성 해야 인스턴스 클래스의 인스턴스 생성 가능
		Outer.InstanceInner a1 = a.new InstanceInner(); // 인스턴스 생성
		
		System.out.println("a1.lv = "+a1.iv);
		System.out.println("외부객체 iv = "+Outer.StaticInner.cv);
		
		Outer.StaticInner s = new Outer.StaticInner(); // static 내부 클래스의 경우 외부 클래스를 먼저 생성하지 않아도 됨. 단, 인스턴스화 할때 외브클래스 이름은 붙여줘야함
		System.out.println(s.iv);
		
		
		
	}

}
