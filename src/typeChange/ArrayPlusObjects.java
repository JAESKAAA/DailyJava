package typeChange;

public class ArrayPlusObjects {

	public static void main(String[] args) {

		
		Buyer2 b = new Buyer2();
		
		b.buy(new Tv2());
		b.summary();
		b.buy(new Audio2());
		b.buy(new Computer2());
		b.summary();
		
	
	}

}

class Product2 {
	int price;
	int bonusPoint;
	
	Product2 (int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}

class Tv2 extends Product2 {
	Tv2() {
		super(100); 
		// TV의 가격을 100으로 설정하여 super생성자를 통해 상위 클래스의 생성자 매개변수에 100을 대입함
		//super 생성자와 super 변수를 헷갈리지 않도록 주의.
	}
	public String toString () {return "TV";}
}

class Computer2 extends Product2 {
	Computer2(){super(200);}
	public String toString () { return "Computer";}
	
}

class Audio2 extends Product2 {
	Audio2(){super(50);}
	public String toString() {return "Audio";}
}

class Buyer2 {
	int money = 1000;
	int bonusPoint = 0;
	
	Product2[] cart = new Product2[10]; // 구입한 제품을 저장할 배열

	int i=0; //product 배열에 사용될 카운터 
	
	void buy(Product2 p) { // 매개변수 타입이 Product이기 때문에, Product를 상속하는 클래스는 모두 객체화하여 들어올 수 있음
		if(money < p.price) {
			System.out.println("잔액이 부족하여 구매가 불가능합니다.");
			return;
		}
		money -=p.price;
		bonusPoint += p.bonusPoint;
		cart[i++] = p; // 제품의 Product[]을 cart에 저장하고 i값을 +1 만듬 (조건에 의한 반복이 아닌점 주의)
		System.out.println(p+"을/를 구매하였습니다."); 
		//참조변수를 직접쓰면 p.toString으로 출력이 됨. 따라서 원래라면 참조변수의 인스턴스 주소가 찍히겠지만,각 클래스에 toString을 오버라이드 했기 때문에 문자열로 나옴
	}
	
	void summary () {
		int sum =0;
		String itemList ="";
		
		//반복문을 이용해 구매 총액과 구매 내역을 정리함
		for(int i=0; i<cart.length; i++) {
			if(cart[i]==null) { // cart가 비어있으면 반복문 정지
				break;	}
			sum+= cart[i].price;
			itemList +=cart[i].toString()+",";
			}
		System.out.println("구입하신 물품의 총액은 "+ sum+"만원 입니다.");
		System.out.println("구입하신 제품은 "+ itemList+"입니다.");
		}
	}
