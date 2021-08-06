package polymorphism;

class Cake {
	public void sweet() {System.out.println("Cake.sweet()");}
	public void send() {System.out.println("Cake...sending");}
	
}

class CheeseCake extends Cake {
	public void milky() {System.out.println("CheeseCake.milky()"); }
}

class StrawberryCheeseCake extends CheeseCake{
	public void sour() {System.out.println("StrawberryCheeseCake.sour()");}
}

public class CakeControlCode {
	public static void main (String[] args) {

		
		//일괄처리(배열관점에서 정리)
		Cake[] cakes = new CheeseCake[10]; // 이렇게 해놓으면 cakes이라는 배열은 치즈케익이 오던, 딸기치즈케익이 오던 다 받아 줄 수있음
//		cakes.send(); // 치즈케익 배열의 자리만 뚫어준것이고 객체를 인스턴스화 하지 않아 send 사용이 안된 것임
		
		for(int i=0; i<cakes.length; i++) {
			cakes[i] = new CheeseCake(); //for문을 이용해 객체를 인덱스 i마다 생성해 주기 떄문에 send 사용이 가능해짐
			cakes[i].send();
		}
		
	}
}
