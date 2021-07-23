package forWhile;

import java.util.Scanner;

public class CalculatorPractice {

	public static void main(String[] args) {

		/*계산기 프로그램을 만들것
		 * 
		 * 사칙연산 기능 구현필요
		 * 더하기 -> 생성자에 인자값을 정수로 받아 그걸 plus 메서드로 더해 정수값 리턴
		 * 빼기-> 생성자에 인자값을 정수로 받아 그걸 minus 메서드로 빼서 정수값 리턴
		 * 나누기-> 생성자에 인자값을 정수로 받아 그걸 divide 메서드로 더해 정수값 리턴
		 * 곱하기-> 생성자에 인자값을 정수로 받아 그걸 multiply 메서드로 더해 정수값 리턴
		 * 
		 * 스캐너를 통해 값을 직접 입력하도록 변경
		 * 콘솔에 입력받은 값을 띄워 줘야함
		 * 
		 * 스캐너로 입력받음 -> switch 문의 매개변수로 사용
		 * 
		 * 
		 * 한번씩 프로그램 실행하기 귀찮아서 반복문을 통해 5번을 누르면 프로그램 종료되는 방향으로 개선하고 싶음
		 * 
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		
		int caseSelect;
		 
	while(true){
		
		System.out.println("원하시는 기능을 입력하세요."); 
		System.out.println("|1. 더하기| |2. 빼기| |3. 나누기| |4. 곱하기| |5. 종료|"); 
		
		String input = sc.next(); //nextLine 입력시 2회차 반복부터 입력값을 받지않고 자동으로 "" 을 받아 에러가 발생됨. nextLine 과 next를 섞어  쓰게되면, nextLine에 \n이 포함되어 있어 그런것으로 보임. 자세한것 다시 찾아보기
		try {
		caseSelect = Integer.parseInt(input);}
		catch (Exception e) {
			System.out.println("잘못입력하셨습니다. 다시입력해주세요");
			continue;
		}
		// ***이슈 발생 ***
		//		caseSelect = Integer.parseInt(input);}
		// 이슈 내용 : 상기 코드에서 입력값을 문자나 문자열로 받게되면 InputMismatchException 에러 발생후 코드 죽음
		// 내일 입력값이 뭐로 받던지 정수로 바꿔주는 법 찾거나 스트링으로 받아도 상관없이 수행되도록 코드 다시 짜보기
		
		//***이슈해결!***** 2021.07.23일 수정완료 !
		// 문자 입력시 caseSelect 변수에 integer가 parsing되도록 설정되어 있어, 문자 입력을 받지못해 에러가 발생하는 것이었음
		// 사용자가 실수로 문자를 입력하게되면 예외처리해서 다시 while문으로 돌아가도록 처리함. 
		if (caseSelect == 5) { //처음에는 프로그램을 종료하는 기능을  스위치문 마지막 케이스로 넣었더니 정상 작동 되지않아 맨위로 올려서 if문으로 조건 바꿔 해결하였음
			System.out.println("프로그램을 종료합니다.");
			break; //5를 입력하면 프로그램 종료합니다 출력후 break로 반복문 빠져 나감
			
		} else if (caseSelect < 0 || caseSelect >6){ // 입력값이 1~5가 아니면 하기 코드실행 후 continue통해 while 처음으로 다시 이동
			System.out.println("잘못된 값입니다. 다시 입력 해 주세요.");
			continue; 
		} 
		
		System.out.println("첫번쨰 입력값을 설정해 주세요"); //입력값이 정상이라면 첫번째 값 입력
		int value1 = sc.nextInt(); //nextInt로 정수값 받음. 추후에는 혹시라도 문자열이나 스트링입력하는 사람들있을수 있으니 parseInt처리 해야할듯
		System.out.println("두번쨰 입력값을 설정해 주세요"); 
		int value2 = sc.nextInt(); 
		
		switch(caseSelect) {
		case 1: 
		System.out.println("값은 "+(value1+value2)+"입니다.");
		continue;
		case 2: 
		System.out.println("값은 "+(value1-value2)+"입니다.");
		continue;
		case 3: 
		System.out.println("값은 "+(value1/value2)+"입니다.");
		continue;
		case 4: 
		System.out.println("값은 "+(value1*value2)+"입니다.");
		continue;
		}
	}//while
	System.out.println("굳나잇"); //반복문 빠져나가면 굳나잇 출력
	}// main
} //Main class
