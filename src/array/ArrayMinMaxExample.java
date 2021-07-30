package array;

import java.util.Arrays;

public class ArrayMinMaxExample {

	public static void main(String[] args) {

		/*
		 * int형 1차원 배열을 매개변수로 전달받아 배열에 저장
		 * 최대값, 최소값을 찾아서 반환하는 메서드를 각각 다음의 형태로 구현
		 *  public static int minValue(int[] arr) : 최소값 
		 */
		
		int [] arr = {6,3,4,5,6,7,1,2,-1};
		

		System.out.println(min(arr));
		System.out.println(max(arr));
		System.out.println(Arrays.toString(arr));
		
		
	}

		public static int min(int[] ar) {
			int minValue =ar[0]; //첫번째 기준이 되는 배열값을 초기 설정해줌
			for( int i=0; i<ar.length; i++) {
				if(ar[i]<minValue) {//arr[i]가 기준값보다 작은 경우 arr[i]를 minValue 변수에 담아줌으로써 자신보다 작거나 같은 값만을 저장하게됨
					minValue= ar[i];
					
				}
			} return minValue;
			
		}
		
		public static int max(int[] ar) {
			int maxValue = ar[0];
			for(int i=0; i<ar.length; i++) {// 최소값과 반대로, arr[i]가 기준값 보다 큰경우 maxValue 변수에 arr[i]값을 담아줌
				if(ar[i]>maxValue) {
					maxValue = ar[i];
				}
			}
			return maxValue;
		}
}
