package CrudPractice;

import java.util.Scanner;

//Model 부분(주요 기능, 데이터 저장, 가공, 로직 구현)
public class Dmo {
	
	Scanner sc = new Scanner(System.in);
	
	Dco[] dcoArr = new Dco[20]; //Dco의 멤버 사용하는 배열 20칸 생성

	//변수 선언
	private boolean swit[] = new boolean[20]; //페이지가 비었는지 확인하기 위한 boolean 배열 20칸 생성
	private int pageNum;
	private String check;
	private String inputPageNum;
	
	//생성자
	public Dmo() {
		init(); // 최초에 페이지는 전부 비어있어야 하므로 init 메서드로 swit 배열 값을 전부 false로 변경
	}
	
	public void init() {
		for(int i=0; i>swit.length; i++) {
			swit[i] = false;
		}
	}

	public void insert() {
		System.out.println();
		
		//페이지 비어있는지 먼저 확인
		for(int i=0; i<dcoArr.length; i++) {
			if(swit[dcoArr.length-1]==true) { //swit[0]선택을 위해 -1 조건 추가
				System.out.println("더이상 페이지를 추가할 수 없습니다.");
				return;
			} else{
				System.out.println((i+1)+"번 페이지에 작성 가능 힙니다.\n");
				
				break;
			}
		}
		
		//데이터 입력 부분 (이름, 나이, 성별, 생년월일, 사는곳)
		//최초에 next로 입력을 받았지만, 개행문자 때문에  다음 case문으로 넘어가는 현상이 발생하여 nextLine으로 변경
		System.out.print("이름을 입력해 주세요. >>");
		String name = sc.nextLine();
		
		System.out.print("나이을 입력해 주세요. >>");
		String age = sc.nextLine();
		
		System.out.print("성별을 입력해 주세요. >>");
		String sex = sc.nextLine();
		
		System.out.print("생년월일을 입력해 주세요. >>");
		String birth = sc.nextLine();

		System.out.print("사는 곳(도시명만) 입력해 주세요. >>");
		String city = sc.nextLine();
		
		for(int i=0; i<dcoArr.length; i++) { //페이지 수량 만큼 반복
			if(swit[i] == false) { //빈페이지 인지 확인
				swit[i] = true; //페이지를 true로 변경하여 채워져있게 만듬
				pageNum = i+1; // 페이지번호 기입
				dcoArr[i] = new Dco(pageNum, name, age, sex, birth, city);
				System.out.println("\n"+pageNum+"번째 페이지가 작성 완료 되었습니다.");
				break;
			}
		}
	} //insert 메서드 끝
	
	public void search() {
		System.out.println();
		System.out.println("검색하고 싶은 페이지를 입력해 주세요. [1~20까지]>>");
		inputPageNum = sc.nextLine();
		pageNum = Integer.parseInt(inputPageNum);
		
		//페이지 비어있는지 확인
		if(dcoArr[pageNum-1]==null) {
			System.out.println("해당 페이지는 비어있습니다.");
			return;
		}
		//페이지 출력
		System.out.println(pageNum+"번 페이지의 내용입니다.");
		System.out.println(dcoArr[pageNum-1].toString());
		
	} // search 메서드 끝
	
	public void update() {
		System.out.println();
		System.out.println("수정하고 싶으신 페이지를 입력해 주세요. >>");
		inputPageNum = sc.nextLine();
		pageNum = Integer.parseInt(inputPageNum);
		
		//페이지 검사
		if(dcoArr[pageNum-1]==null) {
			System.out.println("비어있는 페이지 입니다.");
			return;
		}
		System.out.println("선택된 "+pageNum+"페이지의 내용 입니다.");
		System.out.println(dcoArr[pageNum-1].toString());
		System.out.println("페이지를 수정하고 싶으시면 'Y' 를 아니면 'N'을 입력해 주세요.");
		// next로 처리하면 개행문자가 저장되어 이름 입력 후 바로 나이입력해달라는 문구가 작동됨
		// 또한 nextLine으로 바꿈으로서 90라인쯤 pageNum입력 받는 nextInt를 사용하지 못하게 되어 부득이하게 nextLine으로 받은 후 parseInt 처리함
		check = sc.nextLine();
		
		//수정 여부 체크 후 다시 입력
		if(check.equalsIgnoreCase("y")) { //대소문자 구분 없이 입력 가능하게 함

			System.out.print("이름을 입력해 주세요. >>");
			String name = sc.nextLine();
			
			System.out.print("나이을 입력해 주세요. >>");
			String age = sc.nextLine();
			
			System.out.print("성별을 입력해 주세요. >>");
			String sex = sc.nextLine();
			
			System.out.print("생년월일을 입력해 주세요. >>");
			String birth = sc.nextLine();

			System.out.print("사는 곳(도시명만) 입력해 주세요. >>");
			String city = sc.nextLine();
			
			dcoArr[pageNum-1] = new Dco(pageNum, name, age, sex, birth, city);
			System.out.println("\n 페이지가 수정 되었습니다.");
		} else {
			System.out.println("\n 페이지를 수정하지 않습니다.");
		}
	} //update 메소드 끝
	
	public void delete() {
		System.out.println("\n 삭제하고 싶은 페이지를 입력 해 주세요");
		inputPageNum = sc.nextLine();
		pageNum = Integer.parseInt(inputPageNum);
		
		//페이지 검사
		if(dcoArr[pageNum-1]==null) {
			System.out.println("해당 페이지는 빈 페이지 입니다.");
			return;
		}
		System.out.println("\n 삭제하고 싶으신 "+pageNum+"페이지의 내용입니다.");
		System.out.println(dcoArr[pageNum-1].toString());
		System.out.println("해당 페이지를 삭제 하고 싶으시면 'Y'를, 아니면 'N'을 입력 해 주십시오.");
		check = sc.nextLine();
		//삭제 여부 체크
		if(check.equalsIgnoreCase("y")) {
			swit[pageNum-1] = false;
			dcoArr[pageNum-1] = null;
			System.out.println("\n 페이지가 삭제 되었습니다.");
		}else {
			System.out.println("페이지 삭제를 취소 합니다.");
			
		}
	}// delete 메소드 끝
}
