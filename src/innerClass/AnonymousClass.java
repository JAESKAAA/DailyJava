package innerClass;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonymousClass {

	public static void main(String[] args) {
		
		Button b = new Button ("Start");
		b.addActionListener(new ActionListener() { //클래스의 정의와 객체생성을 동시에 함
			public void actionPerformed (ActionEvent e) {
				System.out.println("ActionListener Occurred!");}

		});
	}
	
}

//class EventHandler implements ActionListener {
//	public void actionPerformed (ActionListener e) {
//		System.out.println("ActionListener Occurred!");
//	}
//}