package thread;

import javax.swing.JOptionPane;

public class IOBlocking {

	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
		//싱글쓰레드라서 입력값을 넣어줄 때 까지 하기의 for문을 수행하지 못한다.
		System.out.println("입력하신 값은 "+ input + "입니다.");
		
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
		}
		
	}

}
