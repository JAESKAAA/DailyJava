package lambda;

@FunctionalInterface
interface MyFunction1 {
	void run(); // public abstract 가 생략된 것
}

public class FunctionalInterfacePractice {

	static void execute(MyFunction1 f) { // 매개변수가 MyFunction인 메서드
		f.run();
	}

	static MyFunction1 getMyFunction() {
//		MyFunction1 f = () -> System.out.println("f3.run()");
//		return f;
		return ()->System.out.println("f3.run()"); //상기 코드를 한줄로 축약
	}

	public static void main(String[] args) {
		//람다식으로 Myfunction1의 run 구현
		MyFunction1 f1 = ()->System.out.println("f1.run()");
		
		MyFunction1 f2 = new MyFunction1() { //익명클래스로 run()을 구현함
			public void run() { //public 필수
				System.out.println("f2.run()");
			}
		};
		MyFunction1 f3 = ()-> System.out.println("f3.run()");

		f1.run();
		f2.run();
		f3.run();
		
		execute(()->System.out.println("f1.run()"));
		execute(()->System.out.println("run()"));
		
	}
}
