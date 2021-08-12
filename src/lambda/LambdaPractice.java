package lambda;

public class LambdaPractice {

	public static void main(String[] args) {
//		Object obj = (a,b) -> a>b? a:b; //람다식이며 익명 객체이므로 참조 변수가 필요함
//		MyFunction f = new MyFunction() { //객체를 다루기위해 참조변수 obj를 만들어 줌
//			public int max(int a, int b) { //오버라이딩 규칙으로 인해 접근 제어자를 맞춰줘야함 (메서드에서 생략시 디폴트로 설정되어있음)
//				return a > b ? a : b;
//			}
//		};
//		int value = obj.max(3,5); // 에러나는 이유는 Object 타입의 객체에는 max라는 메소드가 없기 때문. 이때 필요한 것이 함수형 인터페이스임
		MyFunction f = (a,b)->a > b ? a : b; // 람다식 표현, 람다식을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 함
		
		int value1 = f.max(3, 5);
		System.out.println(value1);
	}
}

@FunctionalInterface //함수형 인터페이스는 단 하나의 메소드만 가져야 함
interface MyFunction {
	public abstract int max (int a, int b);
	
}