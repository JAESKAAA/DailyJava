package src.generics;

import java.util.*;

public class hashMapForGenerics {

	public static void main(String[] args) {

		HashMap<String, Student> map = new HashMap<>();
		
		map.put("강호동", new Student("강호동", 1, 1, 100, 100, 100));
		
		Student s = map.get("강호동");
		System.out.println(map); //객체는 참조 주소를 콘솔에 띄워줌 이걸 제대로 띄우려면 toString을 오버라이드 해줘야함
		System.out.println(s.name);	//이렇게 변수에 name필드를 사용해 출력 가능
		System.out.println(map.get("강호동").name); //이런식으로 한줄로 표현도 가능함
	}//main
}//main class

class Student {
	String name ="";
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	Student(String name, int ban, int no, int kor, int eng, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}
}