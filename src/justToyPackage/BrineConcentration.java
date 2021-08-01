package justToyPackage;

import java.util.Scanner;

public class BrineConcentration {

	public static void main(String[] args) {
		
		/*소금물 농도 구하는 프로그램
		 * 내일 구현할거
		 * 1. 메뉴선택 만들기
		 * 2. 농도 입력란을 추가하고, 소금, 물, 농도 중 하나가 빠진상태에서 입력하면 구해주는 로직 짜보기
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("*******소금물 농도 구하는 프로그램*********");
		System.out.println("물의 양을 입력해 주세요. >");
		int waterValue = sc.nextInt();
		System.out.println("소금의 양을 입력해 주세요. >");
		int saltValue = sc.nextInt();
		
		double brineConcentration = (double)saltValue/waterValue*100;
		double water = (double)saltValue/brineConcentration*waterValue;
		double salt = ((double)brineConcentration*waterValue) / 100;
		System.out.println("소금물의 농도는 = "+brineConcentration+"% 입니다.");
		System.out.println("소금의 양은 = "+salt+"g 입니다.");
		System.out.println("물의 양은 = "+water+"g 입니다.");
	
	}

}
