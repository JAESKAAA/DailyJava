package functionPackage;

import java.util.function.*;
import java.util.*;

/* 지네릭스 부분 아직 잘 이해 안가서 복습 필요함
 * 람다식 실습 좀 더 필요
 */
public class VariousFunctionInterface {

	public static void main(String[] args) {
		// 매개변수 없고 반환값만 있는 경우 Supplier
		Supplier<Integer> s = ()->(int)(Math.random()*100)+1;
		// 매개변수는 있지만 반환값이 없는 경우 Consumer
		Consumer<Integer> c = i->System.out.print(i+", ");
		// 반환값이 boolean인 경우 Predicate
		Predicate<Integer> p = i->i%2==0;
		// 일반적 함수, 매개변수 하나 받고 반환값도 하나
		Function<Integer, Integer> f = i -> i/10*10;
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list); //list를 랜덤값으로 채운다
		System.out.println(list);
		printEvenNum(p, c, list);
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
		
		
	}
	
	static <T> List<T> doSomething(Function<T,T> f, List<T> list){
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i: list) {
			newList.add(f.apply(i)); //1의자리를 없애서 새로운 리스트에 저장
			}
		return newList;
	}

	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for(T i : list) {
			if(p.test(i)) { //Consumer(짝수검사)를 테스트한 후 true/false 반환
				c.accept(i); //true면  i->System.out.println(i+", "); 출력
			}
		}
		System.out.println("]");
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
	for(int i=0; i<10; i++) {
		list.add(s.get()); //Supplier로 부터 1~100까지 난수 받아 list에 추가
	}
	}
}
