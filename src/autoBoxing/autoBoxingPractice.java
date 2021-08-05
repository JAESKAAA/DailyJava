package autoBoxing;

import java.util.ArrayList;

public class autoBoxingPractice {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(100); //list에는 객체만 추가할 수 있어서, jdk 1.5이전에는 이게 불가능했음.
		list.add(new Integer(200)); //원래는 이게 맞는 것이지만, 상기 코드는 오토박싱 처리되어 객체로 변환되었기 때문에 가능 한 것임
		
		int i = list.get(1).intValue(); //원래는 이렇게 해야 객체를 기본형타입으로 언박싱 처리해줌
		int i2 = list.get(0); //자동 언박싱으로 인해 이렇게 출력 가능해짐
		
		
	}

}
