package functionPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionFWAndFI {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i< 10; i++) {
			list.add(i);
		}
		//리스트의 모든 요소를 출력
		//forEach는 Consumer인터페이스를 구현하여, 매개변수받기만 하고 리턴값은 없음. 따라서 매개변수 하나만 지정해 주면 됨
		list.forEach(i->System.out.print(i+","));
		System.out.println();
		
		//람다식 이전 리스트를 출력하는 방법
//		System.out.println(list);
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		//2또는 3의 배수를 리스트에서 제거
		list.removeIf(x -> x%2==0 || x%3==0);
		System.out.println(list);
		
		//list의 각 요소에 10을 곱함
		list.replaceAll(i -> i*10);
		System.out.println(list);
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		//map의 모든형식을 {k,v}형태로 출력
		map.forEach((k,v)->System.out.print("{"+k+","+ v+"}, "));
		System.out.println();
	}

}
