package thread;

import javax.swing.JOptionPane;

class NewThread extends Thread {
	public void run() {
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
		}
	}
}

public class IOBlocking_Multi {

	public static void main(String[] args) {
		//멀티쓰레드로 설계하여 NewThread 객체 생성
		NewThread th1 = new NewThread();
		//th1 쓰레드의 메소드 실행. main 쓰레드와 별개이므로 하기의 input값이 입력되지 않아도 계속 수행됨
		th1.start();
		
		String input = JOptionPane.showInputDialog("입력값을 넣어주세요");
		System.out.println(input);
		
	}

}
