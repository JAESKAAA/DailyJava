package calendar;

import java.util.Calendar;

public class CalendarPractice2 {

	public static void main(String[] args) {
		final String[] WEEKDAYS = {"", "일","월","화","수","목","금","토"};
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		//MONTH의 경우 0부터 시작하기 때문에 8월은 7로 설정
		cal.set(2021, 7, 4); // 2021년 8월 5일로 설정 
		System.out.println("어제는 "+ toString(cal)+ WEEKDAYS[cal.get(Calendar.DAY_OF_WEEK)]+"요일이고,");
		System.out.println("오늘은 "+ toString(cal2)+ WEEKDAYS[cal2.get(Calendar.DAY_OF_WEEK)]+"요일입니다.");
	
		// 두날짜간의 차이얻기
		long difference = (cal2.getTimeInMillis() - cal.getTimeInMillis())/1000;
		System.out.println("어제부터 오늘까지는 약 "+difference+"초가 지났고,");
		System.out.println("일수로 환산하면 "+(difference)/(60*60*24)+"일이 지났습니다");
		
		//D-Day 계산해보기
		Calendar dDay = Calendar.getInstance();
		dDay.set(2022, 0, 30); //2022년 1월 30일

		long differ = (dDay.getTimeInMillis() - cal2.getTimeInMillis())/1000;
		System.out.println("다음 여자친구 생일까지 "+(differ)/(60*60*24)+"일 남았습니다.");
		
		//지나온 일수 계산해 보기
		Calendar first = Calendar.getInstance();
		first.set(2018, 5, 6); // 2018년 6월 6일
		long differ2 = (cal2.getTimeInMillis() - first.getTimeInMillis())/1000;
		System.out.println("첫만남부터 "+(differ2)/(24*60*60)+"일이 지났습니다.");
	}

	private static String toString(Calendar cal) {
		return cal.get(Calendar.YEAR)+"년 " +(cal.get(Calendar.MONTH)+1)+"월 "+cal.get(Calendar.DATE)+"일 ";
	}

	
}
