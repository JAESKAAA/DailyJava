package thread;

//하기와 같이 코딩한 경우 상속 받은 쓰레드와, 인터페이스를 구현한 쓰레드 두개가 동시에 돌아가므로 멀티 쓰레드의 특성을 보임.
//하여, 출력된 결과를 보면 0과 1이 혼용 되어 있는 것을 확인 할 수 있다.
class ThreadEx extends Thread { //Thread 클래스 상속하여 구현
	public void run() {//쓰레드가 수행할 작업
		for(int i=0; i<500; i++) {
			System.out.println(this.getName()); //조상인 Thread의 getName을 호출함 (this 생략 가능함)
		}
	}
}

class ThreadIm implements Runnable{ // Runnable 인터페이스 구현하여 쓰레드 구현
	public void run() { //쓰레드가 수행할 작업
	for(int i=0; i<500; i++) {
		//Thread.currentThread() 현재 실행중인 Thread를 반환
		System.out.println(Thread.currentThread().getName());
	}
	}	
}
//만약 하기 클래스에 멀티쓰레드가 아닌 for문을 2개돌리는 싱글스레드로 하게 된다면, 0이 모두 끝난 뒤 순차적으로 1이 모두 출력 될 것임 
public class threadPractice {

	public static void main(String[] args) {

		ThreadEx t1 = new ThreadEx();
		
		Runnable r = new ThreadIm();
		Thread t2 = new Thread(r); // Thread 클래스의 생성자를 이용해 객체 생성
		
		t1.start();
		t2.start();
		
	}

}
