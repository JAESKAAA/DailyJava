package SocketProgram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient2 {
	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("localHost",9000);
		System.out.println("서버연결 완료");
		
		//서버쪽으로 데이터를 보내는 스트림
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		//서버에서 데이터를 읽어오는 스트림
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("> ");
			String sendMsg = sc.nextLine();
			
			dos.writeUTF(sendMsg);
			dos.flush();
			
			//서버로 부터 받은 데이터
			String readMsg = dis.readUTF();
			System.out.println("서버: "+readMsg);
			if(sendMsg.equalsIgnoreCase("exit")) {
				break;
			}
		}
		
//		//메시지 컨테이너
//		String msg = dis.readUTF();
//		System.out.println("받은 메시지: "+msg);
		
		dos.close();
		dis.close();
		sc.close();
		socket.close();
		System.out.println("클라이언트 종료");
		
	}
}
