package JFramePractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JFrame{
	public LogIn() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JLabel pwdLabel = new JLabel("Password : ");
		JTextField textID = new JTextField(10);
		JPasswordField textPW = new JPasswordField(10);
		JButton loginBtn = new JButton("Log In");
		
		
		panel.add(label);
		panel.add(textID);
		panel.add(pwdLabel);
		panel.add(textPW);
		panel.add(loginBtn);
		
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "Dan";
				String pw = "1234";
				
				if(id.equals(textID.getText()) && pw.equals(textPW.getText())) {
					JOptionPane.showMessageDialog(null, "로그인 성공!");
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패. 아이디와 비밀번호를 확인해 주세요.");
				}
			}
		});
		
		add(panel);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new LogIn();
	}

}
