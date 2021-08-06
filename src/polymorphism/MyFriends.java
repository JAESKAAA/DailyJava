package polymorphism;

import java.util.Arrays;

class Friend {
	private String name;
	private String phone;

	public Friend(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	void showInfo() {
		System.out.println("이름:" + name);
		System.out.println("폰번호:" + phone);
	}
	
	String getName() {
		return name;
	}

	void printInfo() {
		System.out.printf("이름: %s /",name);
		System.out.printf(" 번호: %s /",phone);
		
	}
}

class UnivFriend extends Friend {
	private String major;

	public UnivFriend(String name, String phone, String major) {
		super(name, phone);
		this.major = major;
	}

	@Override
	void showInfo() {
		super.showInfo();
		System.out.println("전공: " + major);
	}
	
	@Override
	void printInfo() {
		super.printInfo();
		System.out.printf(" 전공: %s%n",major);

	}
}

class CompFriend extends Friend {
	private String department;

	public CompFriend(String name, String phone, String de) {
		super(name, phone);
		this.department = de;
	}

	void showInfo() {
		super.showInfo();
		System.out.println("부서: " + department);
	}
	@Override
	void printInfo() {
		super.printInfo();
		System.out.printf(" 부서: %s%n",department);
	}
}

public class MyFriends {
	public static void main(String[] args) {

		// 친구의 관리를 위한 배열과 변수
		Friend[] frans = new Friend[6];
		int cnt = 0;

		// 대학친구 추가
		frans[cnt++] = new UnivFriend("Choi", "Tourism", "010-1");
		frans[cnt++] = new UnivFriend("Park", "Accounting", "010-2");
		frans[cnt++] = new UnivFriend("Kim", "Management", "010-3");

		// 직장친구 추가
		frans[cnt++] = new CompFriend("Lee", "R&D", "010-1");
		frans[cnt++] = new CompFriend("Park", "Marketing", "123");
		frans[cnt++] = new CompFriend("Park", "Certification team", "123");

		// 친구 목록 일괄 출력
		for (int i = 0; i < frans.length; i++) {
			frans[i].showInfo();
			if(frans[i].getName().equals("Choi")) {
				System.out.println();
				System.out.println("*********최씨 정보 찾아주세요**********");
				frans[i].printInfo();
				System.out.println();
			}
			
			if (i == 3) {
				System.out.println();
				System.out.println("직장 친구목록");
			}
		}
	}
}
