package forWhile;

import java.util.Arrays;

public class PrintPlayerList {

	public static void main(String[] args) {
		
		/* 2차원 배열을 이용하여 SK와이번수 선수 이름과 나이를 차례로 출력하고 싶음
		 * 
		 * 1. 2차원 배열 생성
		 * 2. 반복문을 통해 이름, 나이 번갈아가면서 출력
		 * 
		 */
		
		
		String[][] arr = {
				{"최정", "김광현", "김성현", "로맥", "한동민"},
				{"30", "33", "29", "25", "23"}
		}; //배열 생성
		
		// Arrays에 deepToString메서드 사용시 2차원 배열을 출력 할 수 있음
		System.out.println("*********2차원 배열 단순 출력**********");
		System.out.println(Arrays.deepToString(arr));
		//반복문을 통한 선수명단 출력
		System.out.println("********SK와이번스 선수 명단**********");
		for (int i=0; i<arr.length-1; i++) { 
			// 처음에는 for문의 조건을 arr.length를 주었더니 34라인의 arr[i+1]때문에 ArrayIndexOutOfBoundsException가 발생함. 
			//총 배열의 길이 = 0,1 두개이며, 첫번째 for문의 길이는 0,1까지라서 -1로 i가 0까지만 반복하도록 설정
			String[] name1 = arr[i];
			// name1 배열에 arr[i]를 담음 -> 최정~한동민까지 담겨서 배열의 길이는 5가 됨
			for(int j=0; j<name1.length; j++) {
				// j=0으로 설정하고, 반복 조건을 첫번째 배열의 길이만큼(5번(0~4)) 반복하도록 설정
				System.out.println("*  이름: "+arr[i][j]);
				System.out.println("*  나이: "+arr[i+1][j]);
				// 기존에 설정된 arr 배열에서 i,j값대로 순서대로 출력하게 만듬
			}
		}
	}

}
