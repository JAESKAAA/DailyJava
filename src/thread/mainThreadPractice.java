package thread;

//멀티쓰레드의 예시임. 하나의 클래스로 Thread를 설계하게 되면 싱글 쓰레드의 작업이 수행됨
class Thread1 extends Thread{
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print(new String("-"));
		}
	}
}

class Thread2 extends Thread {
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print(new String("|"));
		}
	}
	
}

public class mainThreadPractice {

	static long startTime = 0;
	public static void main(String[] args) {

		Thread1 th1 = new Thread1();
		Thread2 th2 = new Thread2();
		
		th1.start();
		th2.start();
		
		delay(2*1000);
//		try {
//			th1.join(); //main 쓰레드가 th1의 작업 끝날때 까지 기다림
//			th2.join(); //main 쓰레드가 th2의 작업 끝날때 까지 기다림
//			//이것으로 인해 main쓰레드가 종료되도 쓰레드가 남아있으면 프로그램이 종료되지 않음을 확인 할 수 있음
//		}catch (InterruptedException e) {
//		}
		
		startTime = System.currentTimeMillis();
		
		
		System.out.print("소요시간"+(System.currentTimeMillis() - startTime));
		
		
	}
	// sleep에 매번 예외처리하기 번거로워서 메소드로 정의
	static void delay(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {}
	}

}
