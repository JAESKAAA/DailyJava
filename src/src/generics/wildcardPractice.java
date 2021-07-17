package src.generics;

import java.util.ArrayList;

class Fruit2 {

	@Override
	public String toString() {
		return "Fruit";
	}
}

class Apple2 extends Fruit2 {
	@Override
	public String toString() {
		return "Apple";
	}
}

class Grape2 extends Fruit2 {
	@Override
	public String toString() {
		return "Grape";
	}
}

class Juice{
	String name="";
	
	Juice(String name){
		this.name = name+"Juice";
	}
	@Override
	public String toString() {
		return name;
	}
}

class Juicer {
	static Juice makeJuice(FruitBox2<? extends Fruit2> box) { //와일드 카드 선언으로 인해 Fruit2 및 Apple2가 사용 가능하여 진 것
		String tmp ="";
		for(Fruit2 f : box.getList()) // 매개변수로 받은 box에서 ArrayList의 리스트 데이터를 하나씩 f 변수에 담음
			tmp += f +" "; //f변수의 값과 공백""을 더해서 tmp에 저장
		return new Juice(tmp); //Jucie 타입의 tmp값을 반환함
		
	}
}
public class wildcardPractice {

	public static void main(String[] args) {

		FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
		FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();
//		FruitBox2<Fruit2> appleBox = new FruitBox2<Apple2>(); //지네릭 타입 불일치로 에러발생
//		FruitBox2<? extends Fruit2> appleBox = new FruitBox2<Apple2>(); //와일드카드 사용으로 Fruit2와 그 자손들(Apple2, Grape2)까지 사용 가능하게 만듬
		
//		//appleBox에 Fruit2 포함 자손들 다 사용 가능
//		appleBox = new FruitBox2<Fruit2>();
//		appleBox = new FruitBox2<Apple2>();
//		appleBox = new FruitBox2<Grape2>();
		
		fruitBox.add(new Apple2()); //fruit박스에 apple 하나 저장
		fruitBox.add(new Grape2()); //fruit박스에 grape 하나 저장
		appleBox.add(new Apple2()); //apple 박스에 애플 하나씩 저장
		appleBox.add(new Apple2()); //apple 박스에 애플 하나씩 저장

		System.out.println("********과일박스 현황*******");
		System.out.println(fruitBox);
		System.out.println("********사과박스 현황*******");
		System.out.println(appleBox);
		System.out.println("********주스에 들어간 과일 현황*******");
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
		
	} // main

}// main class

class FruitBox2 <T extends Fruit2> extends Box2<T>{}

class Box2<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item);}
	T get(int i) { return list.get(i);}
	ArrayList<T> getList() {return list;}
	int size() {return list.size();}
	@Override
	public String toString() {
		return list.toString();
	}
}
