package formattingClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatPractice {

	public static void main(String[] args) {
		DateFormat d1 = new SimpleDateFormat("yyyy년 m월 d일");
		DateFormat d2 = new SimpleDateFormat("yyyy/mm/dd");
		
		try {
			Date d = d1.parse("2021년 8월 6일");
			System.out.println(d2.format(d));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
