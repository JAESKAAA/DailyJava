package CrudProject2;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ProductEnroll {
	//이름으로 조회를 하고싶은데, 객체에서 이름을 매개체로 다른 정보를 불러올 방법을 아직 못찾았음 (근데 되네?...무슨일이지)
	//필드
	Set<Product> set = new HashSet<>();
	
	
	Scanner sc = new Scanner(System.in);
	private int input;
	private int count;
	private String searchProduct;
	Product p = new Product();
	Product t = itr(searchProduct);
	
	DecimalFormat df = new DecimalFormat("###,###"); //데이터 보기 편하게 세자리마다 콤마 찍어주기
	
	
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
		System.out.print("상품명 >");
		p.setPname(sc.nextLine());
		System.out.print("상품 가격 >");
		p.setPrice(Integer.parseInt(sc.nextLine()));
		System.out.println("상품 재고 >");
		p.setStock(Integer.parseInt(sc.nextLine()));
				p.setPno(++count);
		System.out.println("상품 페이지 번호: "+p.getPno());
		set.add(p);
		}
	//제품 등록 기능만 구현
	private void enroll() {
		System.out.print("상품명 >");
		p.setPname(sc.nextLine());
		System.out.print("상품 가격 >");
		p.setPrice(Integer.parseInt(sc.nextLine()));
		System.out.println("상품 재고 >");
		p.setStock(Integer.parseInt(sc.nextLine()));
		
	}
	//제품 출력 메소드
	public void printProduct(Product p) {
		if(p.getPname().equals(searchProduct)) {
			System.out.println("상품 페이지 번호: "+df.format(p.getPno()));
			System.out.println("상품 이름: "+p.getPname());
			System.out.println("상품 가격: "+df.format(p.getPrice()));
			System.out.println("상품 재고: "+df.format(p.getStock()));
		} else {
			System.out.println("해당 제품을 찾을 수 없습니다. 메인 메뉴로 넘어갑니다.");
		}
	}
	//제품 조회 메소드
	public void searchProduct() {
		System.out.println("상품 조회 페이지 입니다.");
		System.out.print("조회를 원하시 제품 이름을 작성해 주세요. > ");

		searchProduct = sc.nextLine();
		printProduct(t);
	}
	
	//제품 수정 메소드
	public void updateProduct() {
		System.out.println("상품 수정 페이지 입니다.");
		System.out.print("수정 원하시는 제품 이름을 작성해 주세요. >");
		searchProduct = sc.nextLine();
		
		System.out.println("수정 원하시는 제품 정보 입니다.");
		printProduct(t);
		System.out.println();
		while(true) {
		System.out.println("제품수정을 원하시면 \"Y\"를, 취소하시려면 \"N\"를 입력해 주세요.");
		String input = sc.nextLine();
		if(input.equalsIgnoreCase("y")) {
			System.out.println("하기 항목을 업데이트 해주세요.");
			enroll();
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
		printProduct(t);
		System.out.println();
		while(true) {
		System.out.println("제품삭제를 원하시면 \"Y\"를, 취소하시려면 \"N\"를 입력해 주세요.");
		String input = sc.nextLine();
		if(input.equalsIgnoreCase("y")) {
			System.out.println("하기 항목을 업데이트 해주세요.");
			set.remove(p);
		} else if(input.equalsIgnoreCase("n")) {
			System.out.println("삭제를 취소합니다.");
			break;
		} else {
			System.out.println("입력정보가 잘못 되었습니다. 다시 입력해주세요.");
			continue;
		}
		}//while문 끝
		
	}
	public Product itr (String searchProduct) {
		Iterator<Product> it = set.iterator();
		while(it.hasNext()) {
			Product p = it.next();
				System.out.println("조회하고 싶은 사람 이름>");
			if(p.getPname().equals(searchProduct)) {
				System.out.println(p.getPname()+"이 검색되었습니다.");
			} else {
				continue;
			}
		}
		return p;
	}
}
