package Exception;

public class practiceForTryCatch {

	public static void main(String[] args) {
	System.out.println(1);
	System.out.println(2);
	
	try {
		System.out.println(3);
		System.out.println(3/0); // ArithmeticException 발생
		System.out.println(4);
	} catch (ArithmeticException e) {
		System.out.println("산술 연산 오류 잡고가자"); //산술 연산 예외 처리		
	} catch (Exception e) {
		System.out.println("무슨 오류인지 파악 부터 하자");
	}
	System.out.println(5);
	
	}
	

}
