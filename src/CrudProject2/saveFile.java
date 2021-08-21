package CrudProject2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class saveFile {

	public static void main(String[] args) {

		String path = "C:\\Dev211\\Studyjava\\DailyJava\\AccountInformation\\Account.db";
		SignUp su  = new SignUp();
		
		//파일 저장
		try {
			OutputStream os = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
