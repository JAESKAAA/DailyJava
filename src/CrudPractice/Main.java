package CrudPractice;

import java.util.Scanner;
/*
 *************[자바를 이용한 CRUD 연습용 게시판 v1.0]******************
 * 
 * 개선 필요 사항들
 * 1. 입력값이 메뉴얼에서 벗어날때 예외처리문 작성 필요
 * 2. 페이지 출력시 진짜 페이지 형식으로 출력하게 만들고 싶음
 * 
 * **********************************************************
 */


//View 부분(사용자가 볼 수 있고, 직접 데이터를 입력하는 부분)
public class Main {

	public static void main(String[] args) {
		
		Dmo dmo = new Dmo();
		
		//스캐너 선언
		Scanner sc = new Scanner(System.in);
		//메뉴 출력 부분
		Loop: while(true) {
		System.out.println("**********************CRUD 게시판 프로토타입 v1.0**********************************");
		System.out.println("1.입력(Insert) | 2. 검색(Search) | 3. 수정(Update) | 4. 삭제(Delete) | 5.프로그램 종료 ");
		System.out.println("*****************************************************************************");
		System.out.print("원하시는 메뉴를 입력해 주세요. >>");
		String selection = sc.nextLine();
		int input = Integer.parseInt(selection);
		
		//스위치문
		switch(input) {
		case 1:
			dmo.insert();
			break;
		case 2:
			dmo.search();
			break;
		case 3:
			dmo.update();
			break;
		case 4: 
			dmo.delete();
			break;
		default :
			System.out.println("프로그램을 종료 합니다.");
			break Loop;
		}//switch 부분
		System.out.println();
		} //While 부분
	}//main 메소드 부분

}//Main 클래스 부분
