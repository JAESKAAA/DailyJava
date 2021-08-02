package Exception;

public class MakeException {

	public static void main(String[] args) {

		try {
//			Exception e = new Exception("고의로 발생 시켰음");
//			throw e;
			
			throw new Exception("고의로 발생 시켰음"); // 위에 두줄을 한줄로 변환
		} catch (Exception e) { // 위에서 예외를 던졌지만, catch블록에서 예외를 잡아 프로그램 정상 종료까지 진행 된 것임
			System.out.println("에러메세지  : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램이 종료 되었습니다.");
	}

}
