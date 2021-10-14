package ActualScoreManagementSystem;

import javax.swing.table.DefaultTableModel;
//DefalutTableModel에 대해 더 공부해보기

interface Score 
{

	public void insert(); //입력 메소드
	public DefaultTableModel outputModel(DefaultTableModel model); //출력메소드
	public DefaultTableModel search(String hak, DefaultTableModel searchModel); //검색
	public DefaultTableModel to_desc(DefaultTableModel model); //순위 메소드(총점으로 내림차순)
	public DefaultTableModel delete(String hak, DefaultTableModel searchModel); //삭제메소드
	public void save(); //저장 메소드
	public DefaultTableModel load(DefaultTableModel model); //출력 메소드
	
	
	
	
}
