package functionPackage;

import java.util.function.Function;
import java.util.function.Predicate;

public class CombinedPredicatePractice {

	public static void main(String[] args) {
			//String 입력, Integer 출력
		Function<String, Integer> f = (s) -> Integer.parseInt(s,16);
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);
		
		//andThen으로 연결하려면 먼저 선언된 함수의 출력값과 나중에 선언된 함수의 입력값의 타입이 같아야함
		Function<String, String> h = f.andThen(g); 
		Function<Integer, Integer> h2 = f.compose(g); //g.andThen(f) 와 똑같음
		
		//"FF"를 16진수 정수타입으로 변경 -> 255출력 -> 2진법문자열로 다시 반환하여 콘솔 출력
		System.out.println(h.apply("FF"));
		// 정수를 이진문자열->16진법으로 변환
		System.out.println(h2.apply(2));
		
		//항등함수
		Function<String, String> f2 = x -> x;
		//입력한 값이 그대로 출력
		System.out.println(f2.apply("AAA"));
		
		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i%2==0;
		Predicate<Integer> notP = p.negate(); // i>=100
		
		// ((i>=100) && (i<200 || i%2==0)) 과 같음
		Predicate<Integer> all = notP.and(q.or(r));
		System.out.println(all.test(150));
		
		String str1 = "abc";
		String str2 = "abc";
		
		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean result = p2.test(str2);
		System.out.println(result);
		
	}

}
