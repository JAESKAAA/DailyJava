package thread;

public class DaemonThreadPractice implements Runnable{

	static boolean autoSave = false;
	public static void main(String[] args) {
		
		//Thread(Runnable r)의 형식으로 받은 것
		Thread t = new Thread(new DaemonThreadPractice()); 
		// Thread start전에 미리 수행해줘야 함. 이부분이 없으면 그냥 쓰레드로 인식해서  종료되지 않음
		t.setDaemon(true); 
		t.start();
		
		for(int i=1; i <=10; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
			System.out.println(i);
			
			if(i==5) {
				autoSave = true;
			}
		}
		System.out.println("프로그램을 종료 합니다.");
	}

	//데몬쓰레드 부분(일반 쓰레드가 종료되면 자동 종료됨)
	public void run() {
		while(true) {
			try {
				Thread.sleep(3*1000); //3초마다 
			} catch (Exception e) {}
			//autoSave가 true면 autoSave() 호출. 처음 5초까지는 자동저장 기능 꺼져있다가 5초 이후로는 3초마다 자동저장 실행됨
			if(autoSave) {
				autoSave();
			}
		}
	}
	public void autoSave() {
		System.out.println("작업파일이 자동저장 되었습니다.");
	}
}
