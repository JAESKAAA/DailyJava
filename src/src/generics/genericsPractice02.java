package src.generics;

import java.util.*;

class Product{}
class Tv extends Product{}
class Audio extends Product{}

public class genericsPractice02 {

	public static void main(String[] args) {

		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Tv> tvList = new ArrayList<Tv>();
		//ArrayList<Product> tvList = new ArrayList<Tv>(); // 상속 관계라고해도 타입이 같지 않아 컴파일 에러 발생
		List<Tv> list = new ArrayList<Tv>(); // 하지만, 클래스의 다형성은 허용 됨
		
		productList.add(new Tv());
		productList.add(new Audio());
		//매개변수의 다형성 또한 허용되는데 이게 가능한 이유는 하기와 같이 add메서드의 코드가 변경 되기 떄문임
		// public boolean add(E e) -> public boolean add(Product e) //매개변수에서 Product 및 자손 클래스들 사용 가능함!!
		
		tvList.add(new Tv()); //매개변수 부분에 Tv가 들어 왔기 때문에, Tv 클래스나 Tv 자손 외에는 들어 올 수 없음
		//tvList.add(new Audio());

		printAll(productList);
		//printAll(tvList); //printAll 메소드의 매개변수 부분 보면 ArrayLsit<Product> 으로 되어있어, 같은 타입인 <Product> 외에는 전부 에러 발생하게 됨
		
		
	} //main

	public static void printAll(ArrayList<Product> li) {
		//향상된 for문: 1. li 배열에서 가져올 값이 존재하는지 평가 -> 2. 값이 존재하면 Product타입의 변수 p에 해당 값을 저장 -> 3. 실행문 실행 후 1로 돌아가 가져올 값이 있는지 확인 후 없으면 for문 종료
		//따라서, for문의 반복 횟수는 배열의 항목 수임
		for(Product p : li)		
			System.out.println(p);
	}
}
