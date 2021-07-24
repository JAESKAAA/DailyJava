package array;

public class ArrayForTwoDemensionEX {

	public static void main(String[] args) {

		int[][] arr = {
				{100, 100, 100},
				{20,20,20},
				{30, 30 ,30},
				{40,40,40}
		};
		
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				sum += arr[i][j];
				System.out.printf("score[%d][%d] = %3d%n", i, j, arr[i][j]);
			}
		}
		
		System.out.println("총합 = "+sum);
	}

}
