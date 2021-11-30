package chatting_program;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public abstract class TcpApplication {

	
	public  static String IP;
	public  static int PORT;
	
	public static String CONFIG = "resources/applicationcontext.ini";
//	public static void main(String[] args) {

//		init();
//		System.out.println(timeStamp());
//	}
	/*
	 * 초기화 메소드
	 */
	public void init() {
	// 저장된 파일로 부터 받아와야함
		Properties settings = new Properties();
		
		try {
			settings.load(new FileInputStream(CONFIG));
			IP = settings.getProperty("IP");
			PORT = Integer.parseInt(settings.getProperty("PORT"));
			
			System.out.println("★IP주소 = "+IP);
			System.out.println("★PORT번호 = "+PORT);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String timeStamp() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
	
	public abstract void start();
}
