package abstractPractice;

abstract class Player { //추상 클래스 (미완성인 클래스라는 개념)
	abstract void play(int pos);  //추상 메서드 (미완성인 메서드라는 개념)
	abstract void stop();	//실행문{ } 을 정의하지 않음 -> 상속받는 클래스에서 재정의해서 사용해야 하기 때문
}

//추상클래스는 상속을 통해 완성해야 객체 생성 가능함

class AudioPlayer extends Player {
	void play(int pos) {System.out.println(pos+"부터 실행합니다."); }
	void stop () {System.out.println("작동을 멈춥니다.");}
	//단 여기서 play나 stop 둘중 하나라도 구현 안되어있으면 해당 클래스도 abstract 처리 해야함
	//abstract 처리되면 당연히 인스턴스화도 안되고 사용할 수도 없음
	
}

public class PlayerTest {

	public static void main(String[] args) {

//		Player p = new Player();  추상클래스는 미완성이라 인스턴스화 되지 않는다!
		
//		AudioPlayer ap = new AudioPlayer();
		Player ap = new AudioPlayer(); // AudioPlayer의 기본생성자가 만들어 졌기 때문에 사용 가능한 것임. 
		ap.play(100);
		ap.stop();
		
	}

}
