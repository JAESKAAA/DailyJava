package JFramePractice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Welcome!!");
		JButton btn = new JButton("click me :)");
		JButton btn2 = new JButton("exit");
		JTextArea textArea = new JTextArea();
		JPanel btnPanel = new JPanel();
		
		btnPanel.add(btn);
		btnPanel.add(btn2);
		panel.setLayout(new BorderLayout());
		panel.add(textArea, BorderLayout.CENTER);
		panel.add(btnPanel, BorderLayout.WEST);
		panel.add(label, BorderLayout.NORTH);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append("You are amazing\n");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
	
		
		
		
		
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setSize(840, 840);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
	}

}
