package stringClass;

public class StringClassMethodPractice {

	public static void main(String[] args) {

		String str = "ABCDE";
		System.out.println(str.charAt(2));
		System.out.println(str.substring(0,4)); // 0~3번 인덱스까지 출력!
		System.out.println(str.substring(1)); // substring의 끝나는 인덱스를 설정 안해주면 끝까지 출력해줌 1~4번인덱스 까지 출력
		
	}

}
