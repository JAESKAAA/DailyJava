package forWhile;

public class GuGuDan {

	public static void main(String[] args) {

		/*
		 * 구구단 for문 2개를 활용하여 구구단 기능 구현
		 * 첫번째 for문을 i=1로 초기화 후, i가 1~9까지 범위 조건을 갖게한뒤, i값을1씩 증가시킴 i가 1이면 두번쨰 for문을 실행 
		 * j=1로 초기화 후, j가 1~9까지 범위를 갖게한뒤 j값을 1씩 증가시킴 
		 * 결과 변수 result를 만들어 i*j의 값을 저장함 출력
		 */

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				int result = i * j;
				System.out.println(i + "단 : " + i + " X " + j + " = " + result);
			}
		}
	}
}
