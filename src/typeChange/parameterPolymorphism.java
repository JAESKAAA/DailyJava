package typeChange;

public class parameterPolymorphism {

	public static void main(String[] args) {

		Buyer b = new Buyer();
		
		b.buy(new Tv1()); //인스턴스화 하여 매개변수로 사용, buy메소드의 매개변수 타입이 Product이지만 상속받았기 때문에 가능 한 것임
		b.buy(new Computer());
		//상기 코드는 하기의 코드를 한줄로 표현한 것임
		// Product p = new Computer(); b.buy(p);
		
		System.out.println("현재남은 돈은 "+ b.money+"만원 입니다.");
		System.out.println("현재 포인트는 "+ b.bonusPoint+"점 입니다.");
	}

}

class Product {
	int price;
	int bonusPoint;
	
	Product (int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}

class Tv1 extends Product {
	Tv1() {
		super(100); 
		// TV의 가격을 100으로 설정하여 super생성자를 통해 상위 클래스의 생성자 매개변수에 100을 대입함
		//super 생성자와 super 변수를 헷갈리지 않도록 주의.
	}
	public String toString () {return "TV";}
}

class Computer extends Product {
	Computer(){super(200);}
	public String toString () { return "Computer";}
	
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	
	void buy(Product p) { // 매개변수 타입이 Product이기 때문에, Product를 상속하는 클래스는 모두 객체화하여 들어올 수 있음
		if(money < p.price) {
			System.out.println("잔액이 부족하여 구매가 불가능합니다.");
			return;
		}
		money -=p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p+"을/를 구매하였습니다."); 
		//참조변수를 직접쓰면 p.toString으로 출력이 됨. 따라서 원래라면 참조변수의 인스턴스 주소가 찍히겠지만,각 클래스에 toString을 오버라이드 했기 때문에 문자열로 나옴
	}
}