package methodReference;

import java.util.function.Function;
import java.util.function.Supplier;

public class methodReference {

	public static void main(String[] args) {
		//원래의 람다식 표현
//		Function<String, Integer> f = (String s) -> Integer.
		
		//메소드 참조로 변환
		Function<String, Integer>  f =  Integer::parseInt;
		
		//함수형 인터페이스에서 값을 적용할때 apply쓰는 것 잊지 않기
		System.out.println(f.apply("100")+200);
		
		//Supplier는 매개변수 안받고 출력만 줌
//		Supplier<MyClass> s = () -> new MyClass(); //람다식
//		Supplier<MyClass> s = MyClass::new; //메소드 참조 형태
		
//		Function<Integer, MyClass> s = (i) -> new MyClass(i); //매개변수 있을때 람다식 표현
		Function<Integer, MyClass> s =  MyClass::new; //매개변수 있을때 메소드 참조
		
		MyClass mc = s.apply(100);
		System.out.println(mc.iv);
		System.out.println(s.apply(200).iv); //새로운 객체 생성하여 해쉬코드가 달라지는 것임
		
		
		//배열을 참조 메소드 형태로
//		Function<Integer, int[]> a = (i) -> new int[i]; // 배열 람다식
		Function<Integer, int[]> a = int[]::new; // 배열 메소드 참조형태로 변환
		
		  System.out.println(a.apply(100).length);
	}

}

class MyClass{
	int iv;
	
	MyClass(int iv){
		this.iv = iv;
	}
}
