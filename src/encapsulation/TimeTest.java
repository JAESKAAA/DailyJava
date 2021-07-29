package encapsulation;

class Time{
	//하기와 같이 public 설정시 외부에서 멤버 변수 변경이 너무 쉬워짐
//	public int hour;
//	public int minute;
//	public int seconds; 
	
	private int hour; //0~23의 수를 가져야 함
	private int minutes;
	private int seconds;
	
	public int getHour() {return hour;}
	public void setHour(int hour) {
		if(hour <0 || hour >23) {
			return;
		}
		this.hour=hour; //0~23에 들어오면 매개변수 hour를 멤버변수 hour에 대입
		
	}
}
public class TimeTest {

	public static void main(String[] args) {
		Time t = new Time();
//		t.hour = 25; 이렇게 쉽게 클래스변수를 조작이 가능함. 오류 발생의 원인이 될 수 있음
		
		t.setHour(22); // 메소드를 통해 간접적으로 클래스 변수를 조작
		System.out.println(t.getHour()); // 메서드를 통해 출력
		//getter와 setter를 이런 식으로 설정 한다는점 참고하기!!
		
	}

}
