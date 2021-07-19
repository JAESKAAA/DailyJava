package src;

public class miniTest {

	public static void main(String[] args) {

		int num1 = 0, num2= 0;
		boolean result;
		
		result = ((num1+=10)>0 && (num2+=10)>0); //양쪽 조건 모두 출력
		System.out.println("num1 = "+ num1 + "num2 = "+num2);
		
		result = ((num1+=10)>0 || (num2+=10)>0); // 둘중 하나만 true 나와도 넘어감
		System.out.println("num1 = "+ num1 + "num2 = "+num2);
	}

}
