package forWhile;

import java.util.*;

public class forWhilePractice {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		int num =0, sum =0;
		
		System.out.println("******각자리수의 합을 구하는 프로그램**************");
		System.out.println("입력값을 기재해주세요 > (ex. 12345)");
		String temp = sc.nextLine(); //여기서 temp에 입력값을 저장
		
		num = Integer.parseInt(temp); //받은 temp값은 String 타입이기 때문에 Integer로 변경해주기
		
		while(num !=0) { //변경한 num 값이 0이 아닌 경우 하기 실행문 실행
			sum += num %10; 
			// 정수에 10으로 나눈 나머지를 구하게되면 마지막 자리수만 남게 된다. 참고!!
			// 정수로 변환한 num값을 10으로 나눈 나머지를 sum의 값과 더해서 sum에 저장
			// ex. 30을 10으로 나눈 나머지 = 0 <- num에 대입 / sum과 더한값 을 sum에 대입 sum=0 
			// 2번째 반복 -> num의 값이 3으로 저장되어있음 . 3은 10으로 나눌수없어 나머지 3이며, sum은 3이 저장됨
			System.out.printf("sum=%3d num=%d%n", sum, num); //sum=첫번째 매개변수값을 정수3자리수로 num = 두번쨰 매개변수값을 정수출력후 개행,
			
			num/=10; 
			//저장되어있는 num=30 (왜냐면 따로 저장 안했으니까) /10 = 3을 num에 저장해서 여기서 num의 값이 3으로 변경됨 while문 앞으로 다시 시작
			//3을 10으로 나눈 정수값은 0만 남기 때문에, 0이 num에 저장 -> while문으로 갔지만 num의 값이 0이기 때문에 false로 반복분 빠져나옴
			
		}
		System.out.println("각자리수의 합: "+sum); // sum에 저장된 값3 출력
		
	
	}

}
