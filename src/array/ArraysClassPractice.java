package array;

import java.util.Arrays;

public class ArraysClassPractice {

	public static void main(String[] args) {

		/* 배열 관련 기초 다시 정리*/
		
		int [] arr = {0,1,2,3,4,5}; //1차원 배열 생성
		int [][] arr2D = {{11,12},{21,22}}; // 2차원 배열 생성
		
		System.out.println(Arrays.toString(arr)); // 배열 출력할때는 Arrays클래스를 import해서 toString 메서드로 출력하기
		System.out.println(Arrays.deepToString(arr2D)); // 다차원 배열 출력할때는 deepToString 메서드로 출력하기
		
		String [][] str2D = {{"aaa","bbb"},{"AAA","BBB"}};
		String [][] str2D2 = {{"aaa","bbb"},{"AAA","BBB"}};
		
		System.out.println(str2D == str2D2); // false를 반환하는 이유는 두 배열의 참조 변수 값(메모리 주소)를 비교 하기 때문임
		System.out.println(Arrays.deepEquals(str2D, str2D2)); // 다차원 배열이기 때문에 deepEquals를 사용하여 비교
		
		int [] arr2 = Arrays.copyOf(arr, arr.length); // arr을 arr의 배열 길이만큼 복사해서 arr2라는 int배열 생성. 숫자넣으면 숫자만큼 배열값 복사가능하며, 배열 값보다 복사하는 숫자가 크면 나머지 공간은 0으로 채움
		int[] arr3 = Arrays.copyOfRange(arr, 1, 5); // arr배	열 1~4 (5는 포함안됨) 까지 복사해서 배열 arr3 생성
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		
		int[] arr4 = {3, 6, 8, 2, 1, 0};
		System.out.println(Arrays.toString(arr4)); // 정렬 전
		System.out.println(Arrays.toString(arr4)); // 오름차순 정렬
	}

}
