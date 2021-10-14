package ActualScoreManagementSystem;

import java.util.*;

import java.io.*;

public class ScoreDTO implements Serializable, Comparable <ScoreDTO> {
	//Comparable-> 객체정렬에 필요한 메서드를 구현한 인터페이스이며, 디폴트인 Comparable 과 디폴트 외의 기준으로 정렬하는 Comparator가 있음
	// Comparable의 대표적 메소드
	// int compareTo(Object o) -> 객체 o를 자기 자신과 비교 / Comparator에서는 int compare(Object o1, Object o2) 가 있음. 두객체 비교
	// 기준값 - 비교대상값 으로 진행되기때문에, 음수가 나오면 비교값이 큰것, 0은 같은것, 양수는 기준값이 큰것

	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	public ScoreDTO(String hak, String name, int kor, int eng, int math) {
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = kor+eng+math;
		this.avg = tot/3;
		
	}
	public String getHak() {return hak;}
	public String getName() {return name;}
	public int getKor() {return kor;}
	public int getEng() {return eng;}
	public int getMath() {return math;}
	public int getTot() {return tot;}
	public double getAvg() {return avg;}
	
	@Override
	public int compareTo(ScoreDTO o) { //나이를 기준으로 compareTo 오버라이드
		if(getTot()<o.getTot()) return -1;
		else if (getTot()==o.getTot()) return 0;
		else return 1;
	}
	@Override
	public String toString() {
		return hak + ","+ name + "," + kor + "," + eng + "," + math  + "," + tot  + "," + avg;
	}
}