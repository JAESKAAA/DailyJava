package ActualScoreManagementSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.events.WindowEvent;

 class ScoreForm extends JFrame implements ActionListener{

	 private JLabel hakL, nameL, korL, engL, mathL;
	 private JLabel[] allLabel;
	 private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7;
	 private JButton[] allBtn;
	 private JTextField hakT, nameT, korT, engT, mathT;
	 private JTextField[] allText;
	 private DefaultTableModel model;
	 private Vector <String> head; 
	 // 벡터는 컬렉션프레임워크중 List계열의 하나이며, 동기화된 메소드로 구성되어 멀티스레드가 동시에 벡터 메소드를 사용할 수 없음. 
	 //즉 하나의 스레드가 메소드를 완료해야 다음 스레드가 메소드 사용 가능함. 이로인해 스레드 환경에서 안전하게 객체를 추가 삭제 할수있음
	 private JTable table;
	 private ScoreImple si;
	 
	 public ScoreForm() {
		 si = new ScoreImple(this);
		 //하단에 버튼 생성
		 JPanel bottom = new JPanel(new GridLayout(1,5,0,0));
		 bt1 = new JButton("입력");
		 bt2 = new JButton("출력");
		 bt3 = new JButton("학번검색");
		 bt4 = new JButton("순위");
		 bt5 = new JButton("삭제");
		 bt6 = new JButton("파일저장");
		 bt7 = new JButton("파일열기");
		 allBtn = new JButton[] {bt1, bt2, bt3, bt4, bt5, bt6, bt7};
		 
		 //버튼에 패널붙이기
		 for(int i=0; i<allBtn.length; i++) {
			 bottom.add(allBtn[i]);
		 }
		 add("South",bottom);
		 
		 //테이블 생성
		 head = new Vector<String>();
		 head.add("학번");
		 head.add("이름");
		 head.add("국어");
		 head.add("영어");
		 head.add("수학");
		 head.add("총점");
		 head.add("평균");
		 model = new DefaultTableModel (head,0);
		 table = new JTable(model);
		 JScrollPane scroll = new JScrollPane(table);
		 
		 //중앙레이아웃
		 JPanel center = new JPanel(new GridLayout(1,2,0,0));
		 JPanel center1 = new JPanel(new GridLayout(5,1,0,0)); //라벨과 텍스트 필드가 담김
		 JPanel []leftP=new JPanel[5];
		 for(int i=0; i<leftP.length; i++) {
			 leftP[i].add("West",allLabel[i]);
			 leftP[i].add("Center",allText[i]);
		 }
		 	//라벨 설정
			hakL=new JLabel("학번");
			nameL=new JLabel("이름");
			korL=new JLabel("국어");
			engL=new JLabel("영어");
			mathL=new JLabel("수학");
			allLabel= new JLabel[]{ hakL,nameL, korL, engL, mathL };

			//텍스트 필드 설정
			hakT= new JTextField("",20);
			nameT= new JTextField("",20);
			korT= new JTextField("",20);
			engT= new JTextField("",20);
			mathT= new JTextField("",20);
			allText = new JTextField[]{ hakT, nameT, korT, engT, mathT };
			
			//패널에 라벨과 텍스트 필드 올리기
			for(int i=0;i<leftP.length;i++){
				leftP[i].add("West",allLabel[i]);
				leftP[i].add("Center",allText[i]);
			}
		 //프레임워크 위에 올리기
		 for(int i=0; i<5;i++) {
			 center1.add(leftP[i]);
		 }
		 center.add(center1); center.add(scroll);
		 add(center);
		 
		 //윈도우 창 설정
		 setBounds(300,500,600,300);
		 setVisible(true);
		 
		 //버튼에 이벤트 설정
		 for(int i=0; i<allBtn.length; i++) {
			 allBtn[i].addActionListener(this);
		 }
		 //이벤트
		 this.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e) {
				 System.exit(0);
			 }
		 });
	 }
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==bt1) { //입력
			 JOptionPane.showConfirmDialog(ScoreForm.this, "정보를 입력합니다.", "정보", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
			 si.insert();
		 }
}
 }
