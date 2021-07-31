package Interface;

/*추상화와 인터페이스의 개념을 잡기위해 스타크래프트 유닛을 기반으로 연습함.
 * 인터페이스와 추상화 사용으로 인해 얻은 장점은 하기와 같음
 * 1.인터페이스 사용을 통해 관련 없는 객체들을 연결시켜 줄 수 있었음. 
 * 2.매개변수에 인터페이스 타입을 넣음으로서 추후 코드 변경에 용이해질 것으로 보임
 * 3.추상화 사용으로 각 객체에 구현해야할 항목을 강제 할 수 있었음
 */

//추상화클래스로 유닛에 기본적으로 공통으로 들어가는 메소드 정의
abstract class Unit2 {
	abstract void move(int x, int y);
	abstract void stop();
}

//지상유닛, 공중유닛, 수리가능 유닛을 나눠 인터페이스화 해줌
interface GroundUnit {void run(GroundUnit a);}
interface AirUnit {void fly(AirUnit b);}
interface Repairable {void repair(Repairable r);}

//마린, 탱크, 드랍쉽 3개의 클래스 생성하여 각 인터페이스와 추상화메소드에 맞게 구현해줌
class Marine extends Unit2 implements GroundUnit{
	void move(int x, int y) {
		System.out.println("["+x+"], ["+y+"] 좌표만큼 움직인다");
	}
	void stop() {
		System.out.println("마린 멈춰");
	}
	public void run(GroundUnit a) {
		System.out.println("마린 뛴다!!");
	}
}

class Tank extends Unit2 implements GroundUnit, Repairable {
	void move(int x, int y) {
		System.out.println("["+x+"], ["+y+"] 좌표만큼 움직인다");
	}
	void stop() {
		System.out.println("탱크 멈춰");
	}
	
	public void run(GroundUnit a) {
		System.out.println("탱크 가속");
	}
	public void repair(Repairable r) {
		System.out.println("탱크 고치는중 입니다");
	}
}

class Dropship extends Unit2 implements AirUnit, Repairable{
	void move(int x, int y) {
		System.out.println("["+x+"], ["+y+"] 좌표만큼 움직인다");
	}
	void stop() {
		System.out.println("드랍쉽 멈춰");
	}
	public void fly(AirUnit b) {
		System.out.println("드랍쉽 날기 시작");
	}
	public void repair(Repairable r) {
		System.out.println("드랍쉽 고치는 중입니다.");
	}
}

public class InterfaceUsingStarcraft {

	public static void main(String[] args) {
		//마린, 탱크, 드랍쉽 객체화
		Marine m = new Marine();
		Tank t = new Tank();
		Dropship d = new Dropship();
		
		System.out.println("*******스타크래프트로 인터페이스 연습**********");
		System.out.println("-------------마린 출격----------------");
		m.move(100, 200);
		m.stop();
		m.run(m);
		System.out.println("-------------탱크 출격----------------");
		t.move(200, 250);
		t.stop();
		t.run(t);
		t.repair(t);
		System.out.println("-----------드랍쉽 출격----------------");
		d.move(150, 300);
		d.stop();
		d.fly(d);
		d.repair(d);
	}

}
