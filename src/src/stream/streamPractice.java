package src.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class streamPractice {

	public static void main(String[] args) throws Exception {
		
		OutputStream os = new FileOutputStream("C:/Temp/test1.db"); 
		// 데이터의 도착지를 test1.db로 하는 바이트 기반 파일 출력 스트림 생성
		//FileOutputStream은 자식 클래스이므로 자동 타입 변환됨
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		
		os.write(a); 
		os.write(b);
		os.write(c);
		// a,b,c 각각 1바이트씩 출력 
		
		os.flush(); //출력버퍼에 잔류하는 모든 바이트 출력
		os.close(); //출력 스트림 종료
		
		//flush 중요!! -> 출력스트림은 출력할 바이트를 바로 보내는 것이 아닌 내부 버퍼(저장소)에 우선 저장해 놓음. 이걸 flush가 모두 출력 하는 역할을 함

		
		InputStream is = new FileInputStream("C:/Temp/test1.db"); //아까 저장한 db파일을 데이터 출발지로 지정함
		while(true) {
			int data = is.read(); //1바이트 씩 읽기
			if (data == -1) break; //파일 끝에 도달하면 반복분 종료
			System.out.println(data);
		}
		is.close(); //입력스트림 종료
	}

}
