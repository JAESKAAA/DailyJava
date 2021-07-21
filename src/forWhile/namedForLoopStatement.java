package forWhile;

public class namedForLoopStatement {

	public static void main(String[] args) {

		Loop1 : for(int i=2; i<=9; i++) {
			for (int j= 1; j<=9; j++) {
				if(j==5)
//					break Loop1;
				break; //이렇게 하면 각 구구단의 5단만 빠져버림
				System.out.println(i+"*"+j+"="+i*j);
			} //end for문1 여기는 일반 break 사용시 
		}//end of Loop1문 break Loop1덕분에 여기로 코드 실행이 됨
		
	}

}
