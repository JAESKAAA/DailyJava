package forWhile;

import java.util.Scanner;

public class doWhilePractice {

	public static void main(String[] args) {
		
		/***** 숫자 입력을 통해 1~100의 랜덤 숫자를 맞추는 프로그램*****
		 * 구현전 기획 목차
		 * 1. 입력을 받을수 있도록 스캐너 클래스를 객체화
		 * 2. 입력값을 담을 변수와 결과값을 담을 int 변수 선언 및 초기화
		 * 3. 스캐너 값이 먼저 실행되어야 하기 때문에 do-while문으로 작성 예정
		 * 4. 반복문 내에 입력 는 코드 작성후 String을 정수값으로 변환해줌 
		 * 5. 반복분 종료 지점에 조건을 answer 값과 input값이 다르면 다시 반복을 돌리도록 설정
		 * 
		 * 구현중 수정 목차
		 * 
		 * 4 ->  작성하다 보니 nextInt로 입력값을 받으면 바로 정수로 바꿀수 있어서 타입변환 코드 작성 X
		 * 숫자가 정답보다 큰지 작은지 몰라서 어려움이 있음
		 * do-while문 중간에 if문 삽입하여 문제 해결
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		int input = 0, answer = 0; 
		 answer = (int)(Math.random()*100)+1;
		
		do {
			System.out.println("**값을 입력해 주세요**");
			System.out.println(">");
			input = sc.nextInt();
			if(input< answer) {
				System.out.println("값을 더 크게 크게 크게 크게");
			} else if(input > answer) { //여길 공란으로 두게되면 정답이 나와도 값을 더 작게작게가 출력되어 조건을 명확하게 명시해주었음
				System.out.println("값을 더 작게 작게 작게 작게");
			}
		}while(answer!= input);
		System.out.println("정답입니다!! answer = "+answer+" 입력값 = "+input);
	}

}
