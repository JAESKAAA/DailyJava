package SocketProgram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer2 {
	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(9000);
		System.out.println("준비완료");
		
		
		Socket socket = server.accept(); 
		System.out.println("클라이언트 연결 완료");
		
		//클라이언트 IP 주소
		System.out.println(socket.getInetAddress());

		//클라이언트로부터 읽어오는 스트림
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		//클라이언트로 데이터를 보내는 스트림
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		while(true) {
			String userMsg = dis.readUTF();
			System.out.println("사용자 메시지 : " + userMsg);
			
			if(userMsg.equalsIgnoreCase("exit")) 
				break;
			
			//받은 메시지를 다시 전송
			dos.writeUTF(userMsg);
			dos.flush();
		}
			
		
		
		dis.close(); //스트림 닫기
		dos.close();
		
		socket.close(); //클라이언트쪽 소켓 닫아주기
		server.close(); //서버소켓 닫아주기
		
		System.out.println("서버 종료");
	}
}
