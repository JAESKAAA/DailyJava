package forWhile;

import java.util.Scanner;

public class BreakAndContinuePractice {

	public static void main(String[] args) {
		int menu = 0, num = 0;
		
		Scanner sc = new Scanner(System.in);
		outer: 
		while(true) {
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			System.out.println("원하시는 메뉴(1~3)를 선택하세요 . *종료는 0번");
			
			String temp = sc.nextLine();
			menu = Integer.parseInt(temp);
			
			if(menu ==0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if(!(1<= menu && menu <= 3)) {
				System.out.println("메뉴 선택이 잘못 되었습니다. 종료는 0번을 눌러주새요.");
				continue;
			}
			for(;;) {
				System.out.println("계산할 값을 입력하세요. (계산종료:0 / 전체종료:99)>");
				temp = sc.nextLine();
				num = Integer.parseInt(temp);
				
				if(num==0)
					break; //계산 종료. for문을 종료함
				if(num==99)
					break outer; //전체 종료. for문과 while문을 전부 벗어남
				
				switch(menu) {
				case 1:
					System.out.println("result= "+ num*num);
					break;
				case 2:
					System.out.println("result= "+ Math.sqrt(num));
					break;
				case 3:
					System.out.println("result= "+ Math.log(num));
					break;
				} //switch문 끝
			} //for문 끝
		} //while문 끝
	} //main 끝

}
