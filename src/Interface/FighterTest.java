package Interface;

abstract class Unit {
	int x, y;

	abstract void move(int x, int y);

	void stop() {
		System.out.println("멈춥니다");
	}
}

interface Fightable {
	public abstract void move(int x, int y);

	public abstract void attack(Fightable f);
}

class Fighter extends Unit implements Fightable {
	// 오버라이딩 규칙 기억하기. (조상보다 접근제어자가 좁으면 안된다.) public 안붙이면 디폴트라는점 꼭 기억하기
	public void move(int x, int y) {
		System.out.println("[" + x + "] , [" + y + "] 로 이동");
	}

	public void attack(Fightable f) {
		System.out.println(f + "를 공격합니다.");
	}

	// 싸울수 있는 상대 불러오기. 타입을 인터페이스로 지정
	Fightable getFightable() {
		Fighter f = new Fighter(); // fighter 객체 생성해서 변수에 담음
		return (Fightable) f;
	}
}

public class FighterTest {

	public static void main(String[] args) {

		Fighter f = new Fighter();
		f.getFightable();
		Fightable f2 = f.getFightable();

	}

}
