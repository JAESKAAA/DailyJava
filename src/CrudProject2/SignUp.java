package CrudProject2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SignUp {
	// 필드
	Map<String, String> map = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	static String path = "C:\\Dev211\\Studyjava\\DailyJava\\AccountInformation\\Account.db";
	public static void main(String[] args) {
		// 데이터 저장
		try {
		OutputStream ops = new FileOutputStream(path);
		}catch(Exception e) {}
		
		
	}
		

	// 아이디 입력
	public void enroll() {
		System.out.println("아이디를 입력해주세요 >");
		String id = sc.nextLine();
		System.out.println("패스워드를 입력해주세요 >");
		String pw = sc.nextLine();
		map.put(id, pw);
		System.out.println(map);
	}
	// 데이터 저장
	
	
}
