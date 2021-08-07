package formattingClass;

import java.text.DecimalFormat;

public class DecimalFormatPractice {

	public static void main(String[] args) {

		DecimalFormat d1 = new DecimalFormat();
		DecimalFormat d2 = new DecimalFormat("#.###E0");
		
		try {
			//parseDouble 처리시 NumberFormatException 발생. 
//			System.out.println(Double.parseDouble("1,234,567.89")); 
			//Number는 숫자계열 최고 클래스 -> d1의 parse메소드를 이용하여 우측 문자열을 숫자에 담아줌
			Number num = d1.parse("1,234,567.89");
			System.out.print("1,234,567.89"+" -> ");
			
			//
			double d = num.doubleValue();
			System.out.print(d+ " -> ");
			
			//숫자를 형식화된 문자로 변환해줌
			System.out.println(d2.format(num));
			
		}catch (Exception e) {
			e.printStackTrace(); //예외 내용을 출력해주는 메서드
		}
		
	}

}
