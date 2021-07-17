package src.generics;

import java.util.*;

public class iteratorForGenerics {

	public static void main(String[] args) {

		ArrayList<Student> list = new ArrayList<>();

		list.add(new Student("강호동", 1, 1));
		list.add(new Student("유재석", 1, 2));
		list.add(new Student("한석규", 2, 1));

		System.out.println(list); // 객체를 담은것이라 객체의 주소가 출력될 예정
		
		System.out.println("*******지네릭스 사용 전 *******");
		
		
		Iterator it = list.iterator(); //Iterator를 이용해 객체의 각 데이터를 변수에 담아 출력
		while (it.hasNext()) {
			Student s = (Student) it.next(); //Iterator에 타입을 지정해 주지 않아, 컴파일러는 어떤 타입인지 모르니까 데이터의 형변환을 입력 해주어야함
			System.out.println(s.name);
//			System.out.println(((Student)it.next()).name); //상기 2줄의 코드를 한줄로 변환
		}
		
		System.out.println("*******지네릭스 사용 후 *******");
		Iterator<Student> it1 = list.iterator();
		while(it1.hasNext()) {
//			Student s = it1.next(); //지네릭스로 타입을 명시해 두어서 따로 형변환 없이 바로 Student s 변수에 담을 수 있음
//			System.out.println(s.name);
			System.out.println(it1.next().name); //상기 2줄의 코드를 이렇게 한줄로 줄이는것이 가능함
			}

	}// main

	//hashMapForGenerics에서도 Student가 나오기때문에, 중복 방지를 위해 접근제어를 private 처리하였고, 인스턴스 변수 생성에 사용 가능하도록 static처리 함
	private static class Student {
			String name = "";
			int ban;
			int no;

			Student(String name, int ban, int no) {
				this.name = name;
				this.ban = ban;
				this.no = no;

			}
		}
}// main class

