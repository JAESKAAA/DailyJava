package Permutation;
import java.util.Scanner;

public class Permutation {

	public static void main(String[] args) {

		//순열을 이용하여 경우의 수를 구하고자함.
		//순열 공식 -> nPr = n! / (n-r)!
		//값을 입력받아 카드 뽑는 경우의 수를 구해보자.
		// factorial 값을 담아주는 변수를 처음에는 int로 잡았는데, 카드숫자가 10개단위 넘어가면 허용 범위를 벗어나 버려서 long으로 변경 해줬음
		
		
		Scanner sc = new Scanner(System.in);
		//메뉴 입력문 출력
		System.out.println("****카드 경우의 수 출력기*****");
		System.out.println("총 카드 갯수를 입력해 주세요. >");
		
		//팩토리얼 작성
		int n = sc.nextInt(); // 입력받은 카드 수량을 n에 저장
		long fac = 1L;
		for(int i=n; i>0; i--) {
			fac = fac*i;
		}
		
		System.out.println("뽑고 싶은 카드의 갯수를 입력해 주세요. >");
		
		int r = sc.nextInt(); // 뽑을 카드 수량을 r에 저장
		long fac2 =1L;
		for(int i=n-r; i>0;i--) {
			fac2 =fac2*i;
		}
		
		long result = (long)(fac/fac2);
//		System.out.println("카드 "+n+"장을 "+r+"개 뽑았을 때의 경우의 수 = "+result+"가지");
		System.out.printf("카드 %d장을 %d개 뽑았을 때의 경우의 수 = %d가지.%n",n,r,result);
			
	}

}
