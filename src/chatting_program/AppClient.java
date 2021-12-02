package chatting_program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AppClient extends TcpApplication{

	public static PrintWriter pw = null; //쓰는 스트림
	public static FileWriter fw = null; //파일보내는 스트림
	public static BufferedReader br = null; // 읽는 스트림
	public static BufferedReader keyboard = null; // 읽는 스트림
	public static BufferedWriter bw = null; // 쓰는 스트림
	public static Socket sSock = null;
	public static Scanner sc = new Scanner(System.in);
	//서버의 IP 주소
	private static String sAddr = null;
	
	//클라이언트 ID
	private String id = null;
	
	/*
	 * 클라이언트 App 실행
	 */
	@Override
	public void start() { 
		System.out.println("★log"+timeStamp());
		System.out.println("\n클라이언트 구동을 시작합니다. ");
		System.out.println("CLIENT start >>");
		
		try {
			//1. 서버 연결
			System.out.println("\n★log"+timeStamp()+"서버에 연결중입니다...");
			sSock = new Socket(IP,PORT); //소켓 연결로 클라이언트 접속시 활성화
	//				Thread th = new Thread (
			sAddr = sSock.getInetAddress().getHostAddress();
			System.out.println("\n★log"+timeStamp()+sAddr +" <- 서버 주소로 연결 되었습니다.");
			
			//2. 보내는 스트림 얻기
			pw = new PrintWriter(new OutputStreamWriter(sSock.getOutputStream()));
			
			//2.1 파일 보내는 스트림 만들어야함
			
			//2.2 받는 스트림 얻기
			br = new BufferedReader(new InputStreamReader(sSock.getInputStream()));
			
			//2.3 키보드 수신 스트림
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			// ********* 로그인 기능 자리**********
			// ***********로그인 인증 기능 (해쉬맵에 로그인 정보 저장하고 거기에 맞는 정보면 다음으로넘어가게)
//			System.out.println("**********************************");
//			System.out.println("| 회원가입은 1번, 로그인은 2번, 종료는 3번");			
//			System.out.println("**********************************");
//			
//			
//			Loop1: while(true) {
//			int input = Integer.parseInt(sc.nextLine());
//			//서버에서 케이스를 나눌수있게 번호를 쏜다
//			pw.println(input);
//			pw.flush();
//
//			switch(input) {
//			case 1 : 
//				System.out.println("회원 가입란입니다. ID와 PW를 입력해주세요.");
//				System.out.print("ID : ");
//				pw.println(sc.nextLine());
//				pw.flush();
//				System.out.print("PW : ");
//				pw.println(sc.nextLine());
//				pw.flush();
//				//서버에서 해당 데이터를 읽고 해쉬맵에 저장해야함
//				break;
//				
//			case 2 : 
//				System.out.println("로그인 페이지 입니다. ID와 PW를 입력해 주세요.");
//				System.out.print("ID : ");
//				//서버로 아이디와 pw 전송
//				pw.println(sc.nextLine());
//				pw.flush();
//				System.out.print("PW : ");
//				pw.println(sc.nextLine());
//				pw.flush();
//				//서버에서 로그인 결과 응답 받아야함
//				String result = br.readLine();
//				System.out.println(result);
//				break Loop1;
//			
//			case 3 : 
//				System.out.println("프로그램 종료");
//				System.exit(0);
//				break;
//				}
//			}
				
			//3. 클라이언트의 id를 전송해주는 부분
			System.out.print("아이디 입력 : ");
			id = keyboard.readLine();
			
			pw.print(id);
			pw.flush();
			
			//4. 접속한 서버의 데이터 수신을 담당할 스레드를 생성하여 실행해야함
			Thread thread = new Thread(new TcpClientHandler());
			thread.start();
			//5. 접속한 서버에게 키보드 입력 메시지를 전송
			String line = null;
			while((line = keyboard.readLine())!=null) {
				pw.println(line);
				pw.flush();
				if(line.equalsIgnoreCase("/quit")) {
					break;
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
