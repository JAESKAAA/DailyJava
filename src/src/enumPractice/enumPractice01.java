package src.enumPractice;

enum Direction {EAST, SOUTH, WEST, NORTH }
//				 0		1	  2      3

public class enumPractice01 {

	public static void main(String[] args) {
		
		//변수에 열거형 저장하는 방법들
		Direction d1 = Direction.EAST; //열거타입.상수이름
		Direction d2 = Direction.valueOf("WEST"); // valueOf를 이용해 문자열을 직접 넣어 저장
		Direction d3 = Enum.valueOf(Direction.class, "EAST"); //열거형 최고 조상인 Enum 클래스를 이용해 저장하는 방법
				
		System.out.println("*******저장 되었는지 출력************");
		System.out.println("d1 = "+d1);
		System.out.println("d2 = "+d2);
		System.out.println("d3 = "+d3);
		
		System.out.println("*******비교 출력************");
		System.out.println("d1 == d2 ? "+ (d1 == d2));
		System.out.println("d1 == d3 ? "+ (d1 == d3));
		System.out.println("d1.equals(d3) ? "+ (d1.equals(d3))); //equal로 비교 가능한 이유는 열거형 데이터 하나하나가 객체이기 때문임.
//		System.out.println("d1 > d3 ? "+ (d1 > d3)); //컴파일 에러발생
		System.out.println("d1.compareTo(d3) ? "+ d1.compareTo(d3)); //값이 같으므로 0 출력
		System.out.println("d1.compareTo(d2) ? "+ d1.compareTo(d2)); // EAST = 0 이고 WEST는 2이므로, 0-2 = -2가 출력됨. 그래서 양수면 왼쪽이, 음수면 오른쪽 값이 크다고 볼수 있음
		
		
		System.out.println("*******스위치문 출력************");
		switch(d1) {
		case EAST : System.out.println("The direction is EAST"); break; //Direction.EAST 라고도 쓸 수 없고 상수이름만 작성하기 (문법상의 이유)
		case SOUTH : System.out.println("The direction is SOUTH"); break;
		case WEST : System.out.println("The direction is WEST"); break;
		case NORTH : System.out.println("The direction is NOTRH"); break;
		default : System.out.println("Invalid direction"); break;
		}
		
		System.out.println("*******열거형 배열 출력************");
		Direction[] dArr = Direction.values(); //열거형의 모든 상수를 배열로 반환
		
		for(Direction d : dArr) {
			System.out.printf("%s=%d%n", d.name(), d.ordinal()); 
			//주의! ordinal은 단순히 상수의 순서를 나타내는 것이며 데이터 값과는 무관함
			// 문자열=정수 \n 이랑 동일한 것임. 첫번재 인자는 name을 문자열로 출력하고, 두번째 인자는 열거값의 순서를 정수로 출력후 줄바꾼다는 코드임
			/*
			 printf("출력하고자하는 형식", 인자들)
			 
			 지시자목록
			 %s -> String 형식으로 출력
			 %d -> Integer 형식으로 출력
			 %f -> float 형식으로 출력
			 %t -> date,time 형식으로 출력
			 %o -> 8진수 integer 형식으로 출력
			 %b -> boolean 형식으로 출력
			 %e -> 지수 형식으로 출력
			 %n -> 줄바꿈
			 */
		}
	}// main

} // main class
