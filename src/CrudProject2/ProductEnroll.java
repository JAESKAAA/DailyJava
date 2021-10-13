package CrudProject2;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ProductEnroll {
	/*
	 ** 2021.08.22 수정사항
	 *  1. iterator로 정확히 검색이 안되던 이슈 해결 -> break 걸어서 해결 했음
	 *  2. printProduct 메소드 매개변수로 t변수 넣었을때는 제대로 작동하지 않았는데, 매개변수에 직접 itr() 도입으로 해결 
	 *  3. updateProduct에 133번라인 실행 후 변경사항이 저장이 안됨. 아마 조회 원하는 객체를 불러와서 set메서드통해 직접 바꾸는 방향으로 코딩해야 할듯 (수정완료)
	 *  
	 *  *남은이슈
	 *  1. 제품 등록 후 바로 삭제는 되는데, 제품 정보를 수정하고나서 삭제가 안됨 원인을 아직 못찾았음.
	 * 	2. 삭제와 수정 시 제품 조회했을때 해당 제품 없으면 loop 메인으로 돌아가도록 설정하기
	 *  3. 코드가 너무 복잡함 코드 경량화 필요
	 *  
	 *  
	 */
	
	//필드
	Set<Product> set = new HashSet<>();
	
	
	DecimalFormat df = new DecimalFormat("###,###"); //데이터 보기 편하게 세자리마다 콤마 찍어주기
	Scanner sc = new Scanner(System.in);
	private int input;
	private int count;
	private String searchProduct ="";
//	Product p = new Product();
//	Product t = itr(searchProduct);
	
	
	
	//메소드
	public void showMenu() {
		Loop1: while(true) {
		System.out.println("-------------------------------------------------");
		System.out.println("1. 제품등록 | 2. 제품조회 | 3. 제품수정| 4. 삭제 | 5. 종료|");
		System.out.println("-------------------------------------------------");
		
		System.out.print("메뉴를 선택해 주세요 >");
		try {
		input = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("1~5까지의 숫자 입력만 허용 됩니다. 올바른 숫자를 기입해 주세요.");
			continue;
		}
		try {
		switch(input) {
		case 1 :
			//등록 메소드
			pEnroll(); 
			System.out.println(set);
			break;
		case 2: 
			//조회 메소드
			searchProduct(); break;
		case 3:
			//수정메소드
			updateProduct(); break;
		case 4:
			//삭제메소드
			deleteProduct(); break;
		case 5: 
			//종료
			 break Loop1;
		} //switch 종료
		} catch(NumberFormatException e) {
			System.out.println("1~5까지의 숫자 입력만 허용 됩니다. 올바른 숫자를 기입해 주세요.");
			continue;
		}
		}//while 종료
	}//showMenu 종료
	
	//제품 등록할때 쓸 메소드
	public void pEnroll() {
		Product p = new Product();
		enroll(p);
		p.setPno(++count);
		System.out.println("상품 페이지 번호: "+p.getPno());
		set.add(p);
		}
	
	
	//제품 조회 메소드
	public void searchProduct() {
		System.out.println("상품 조회 페이지 입니다.");
		System.out.print("조회를 원하시는 제품 이름을 작성해 주세요. > ");

		searchProduct = sc.nextLine();
		printProduct(itr(searchProduct)); 
	}
	
	//제품 수정 메소드
	public void updateProduct() {
		System.out.println("상품 수정 페이지 입니다.");
		System.out.print("수정 원하시는 제품 이름을 작성해 주세요. >");
		searchProduct = sc.nextLine();
		
		Product p = itr(searchProduct); //검색된 객체 가져오기 
		System.out.println("수정 원하시는 제품 정보 입니다.");
		printProduct(p); //제품 정보 출력
		System.out.println();//개행
		
		
		while(true) {
		System.out.println("제품수정을 원하시면 \"Y\"를, 취소하시려면 \"N\"를 입력해 주세요.");
		String input = sc.nextLine();
		if(input.equalsIgnoreCase("y")) {
			System.out.println("하기 항목을 업데이트 해주세요.");
			enroll(p);//
			break;
		} else if(input.equalsIgnoreCase("n")) {
			System.out.println("제품 수정을 취소합니다.");
			break;
		} else {
			System.out.println("입력정보가 잘못 되었습니다. 다시 입력해주세요.");
			continue;
			}
		}//while문 끝
	}
	
	//제품 삭제 메소드
	public void deleteProduct() {
		System.out.print("삭제하고자 하는 제품 이름을 입력해 주세요>.");
		searchProduct = sc.nextLine();
		System.out.println("삭제하고자 하는 제품 정보 입니다.");
		Product p = itr(searchProduct);
		printProduct(p);
		System.out.println(); //개행
		
		Loop2: while(true) {
		System.out.println("제품삭제를 원하시면 \"Y\"를, 취소하시려면 \"N\"를 입력해 주세요.");
		String input = sc.nextLine();
		if(input.equalsIgnoreCase("y")) {
			System.out.println(set.remove(p)); //검색된 제품명 기준의 Product 타입 객체를 삭제함
			System.out.println(searchProduct+" 제품을 삭제합니다.");
			p.setPno(--count);
			break;
		} else if(input.equalsIgnoreCase("n")) {
			System.out.println("삭제를 취소합니다.");
			break;
		} else {
			System.out.println("입력정보가 잘못 되었습니다. 다시 입력해주세요.");
			continue;
		}
		}//while문 끝
	}
	
	//제품 등록 기능만 구현
		private void enroll(Product p) {
			System.out.print("상품명>");
			p.setPname(sc.nextLine());
			System.out.print("상품 가격 >");
			p.setPrice(Integer.parseInt(sc.nextLine()));
			System.out.println("상품 재고 >");
			p.setStock(Integer.parseInt(sc.nextLine()));
		}
		
	//제품 출력 메소드
	public void printProduct(Product t) {
		if(t.getPname().equals(searchProduct)) {
			System.out.println("상품 페이지 번호: "+df.format(t.getPno()));
			System.out.println("상품 이름: "+t.getPname());
			System.out.println("상품 가격: "+df.format(t.getPrice()));
			System.out.println("상품 재고: "+df.format(t.getStock()));
		} else {
			System.out.println("해당 제품을 찾을 수 없습니다. 메인 메뉴로 넘어갑니다.");
		}
	}
	
	//제품 검색 메소드
	public Product itr (String searchProduct) {
		Product p = null; //로컬변수 Product 타입 p를 생성
		Iterator<Product> it = set.iterator();
		while(it.hasNext()) {
			p = it.next(); // p에 set 집합 안에 들어있는 객체를 Iterator로 검색하여 하나씩 담음
			if(p.getPname().equals(searchProduct)) {
				System.out.println("\n"+p.getPname()+"이(가) 검색되었습니다.");
				break;
			} else {
				continue;
			}
		}
		return p; //검색된 p객체를 리턴
	}
}
