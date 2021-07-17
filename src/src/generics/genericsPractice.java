package src.generics;

import java.util.ArrayList;

public class genericsPractice {

	public static void main(String[] args) {

			ArrayList list = new ArrayList(); //지네렉스 포함하지 않았을때
			list.add(10);
			list.add(20);
			list.add("30"); // String으로 문자 추가해도 리스트에는 정상 추가됨
			
//			Integer i = (Integer)list.get(2); 
			//참조변수와 입력값의 데이터 타입이 달라 형변환이 필요한데, 컴파일시에는 문제없이 정수로 형변환이 되지만, 실행시 형변환 관련 예외발생함. -> 컴파일러의 한계임
			//컴파일러는 인덱스2번의 데이터를 꺼낼때 해당 데이터의 타입이 Object라고 인식은 해서 Integer로 캐스팅은 허용 했는데, 안에 있는 데이터의 내용은 읽을 수 없기때문에 프로그램 실행에서 예외가 발생하게 됨.
			System.out.println(list);
			
			ArrayList<Integer> list2 = new ArrayList<Integer>(); //지네릭스 포함했을때
			list2.add(10);
			list2.add(20);
//			list2.add("30"); 입력된 값이 String이라 컴파일 에러가 발생함
			list2.add(30);
			
			Integer i = list2.get(2); //지네릭스로 이미 데이터타입을 제한해두었기 때문에, Integer로 캐스팅 없이 바로 데이터 저장 가능
			
			System.out.println(i);
			System.out.println(list2);
			
			//만약 여러종류의 객체를 저장하고 싶으면 지네릭스를 <Object>로 저장하기
			
	}

}
