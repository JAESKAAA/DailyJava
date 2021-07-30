package abstractPractice;

public class Starcraft {

	public static void main(String[] args) {

		Unit[] group = { new Marine(), new sizeTank(), new Medic()};
		
		for (int i=0; i<group.length; i++) {
			group[i].move(100, 200);
		}
		
	}

}

abstract class Unit {
	int x, y;
	abstract void move(int x, int y);
	void stop() {
		System.out.println("멈춤");
	}
}

//하기에 공통된 부분을 추상 클래스로 묶어보자
// int x,y는 상속으로 Unit에 묶었고 추상메서드인 move는 각 클래스별로 따로 구현함
class Marine extends Unit {
//	int x, y; 상속
	void move(int x, int y) {
		System.out.println("Marine [x = "+x+", y ="+y+"]");	
	}
	void stimPack() {
		System.out.println("가즈아!!!!!!!!!");
	}
}

class sizeTank extends Unit {
//	int x, y; 상속
	void move(int x, int y) {
		System.out.println("tank [x = "+x+", y ="+y+"]");	
	}
	void sizeMode() {
		System.out.println("취익철컥후우우욱척");
	}
}

class Medic extends Unit {
//	int x, y; 상속
	void move(int x, int y) {
		System.out.println("Medic [x = "+x+", y ="+y+"]");	
	}
	void heal() {
		System.out.println("엄마손 아이따뜻해");
	}
}