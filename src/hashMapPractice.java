
import java.util.*;

public class hashMapPractice {

	public static void main(String[] args) {

		// HashMap객체 생성
		HashMap map = new HashMap();

		// 성적표 만들기 (key = String 사람이름, value = int 성적)
		map.put("조세호", 100);
		map.put("유재석", 90);
		map.put("강호동", 85);
		map.put("최민식", 75);

		// 키와 벨류가 잘 들어갔는지 확인
		System.out.println(map);
		System.out.println("---------------------------------------");
		
		// Entry로 만들어서 키값, 벨류값만 따로 추출해보고 싶음
		// map을 Set객체에 entrySet으로 담으면 키/벨류 세트로 담겨지게 됨. 그리고 map에서는 iterator를 쓸수 없어서 set에 담아 사용 가능하게 만듬
		Set set = map.entrySet();
		Iterator it = set.iterator();

		// 상기 코드에서 만든 iterator로 Map의 내부인터페이스인 Entry타입 변수 e를 만들어 it의 next메소드를 이용해 map에 있는 값을 담음
		// 그 후 e변수에 getKey/getValue메소드를 이용헤 저정된 key값 및 value값을 콘솔에 띄움
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) (it.next());
			System.out.println("이름: " + e.getKey() + "\t 점수: " + e.getValue());
		}

		// 시험 참가자 명단만들기
		System.out.println("---------------------------------------");
		System.out.println("시험 참가자 명단: " + map.keySet()); //map 변수에 저장된 값중 key값만 출력
		
		//총점, 평균, 최고점수, 최저점수 출력하기
		int total = 0; //반복문에서 쓸 수 있도록 int 변수 초기화
		Collection value = map.values(); //최고, 최저점수에서 Collections 클래스의 max, min 메소드를 편하게 이용하기위해 Collection 타입으로 map의 value 값들을 저장
		it = value.iterator(); //iterator는 1회용이라 다시 한번 생성하였고, value에서 검색하기 위해 value를 이용해 만듬
		
		while(it.hasNext()) {
			Integer i = (int)it.next(); //value값들을 정수 타입으로 형변환 해서 i 변수에 저장
			total += i.intValue(); // total 변수에 total+i의 int 벨류값을 저장
		}
		System.out.println("---------------------------------------");
		System.out.println("시험 점수 총합: "+ total); 
		System.out.println("평균: "+(float)total/map.size()); //float로 변환해주지 않으면 정수부분만 저장되어 87만 출력됨. 형변환 꼭 필수
		System.out.println("최고점수: "+ Collections.max(value));
		System.out.println("최저점수: "+ Collections.min(value));
		System.out.println("---------------------------------------");
	} //main
} //class
