package calendar;

import java.util.Calendar;

public class CalendarPractice {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance(); //현재 날짜와 시간으로 객체 생성
		int thisYear = cal.get(Calendar.YEAR); // 올해 몇년도인지 가져옴
		int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE); //이달에 마지막달이 몇일인지
		
		//날짜관련
		System.out.println("이달의 년도 = "+cal.get(Calendar.YEAR));
		System.out.println("월(0~11) "+cal.get(Calendar.MONTH));
		System.out.println("이번 년도의 몇번째 주 = "+cal.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이달의 몇번째 주 = "+cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println("이달의 몇일 = "+cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("오늘 몇일? = "+cal.get(Calendar.DATE));
		System.out.println("이번년도의 몇일? = "+cal.get(Calendar.DAY_OF_YEAR));
		System.out.println("무슨요일? (1~7, 1=일요일) = "+cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("이달의 몇번째 요일? = "+cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("오전, 오후 (0=오전,1=오후) ="+cal.get(Calendar.AM_PM));
		//시간 관련
		System.out.println("지금 몇시? = "+cal.get(Calendar.HOUR));
		System.out.println("지금 몇분? = "+cal.get(Calendar.MINUTE));
		System.out.println("지금 몇초? = "+cal.get(Calendar.SECOND));
		System.out.println("1000분의 1초? = "+cal.get(Calendar.MILLISECOND));
		//타임존은 밀리세컨으로 반환함
		System.out.println("TIMEZONE? = "+cal.get(Calendar.ZONE_OFFSET)); 
		System.out.println("이달의 마지막날? = "+cal.getActualMaximum(Calendar.DATE));
		
	}

}
