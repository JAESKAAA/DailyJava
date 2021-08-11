package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MakeTheStream {

	public static void main(String[] args) {
		//List 컬렉션 생성
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		System.out.println(list);
		
		//list를 Stream으로 변경
		Stream<Integer> intStream = list.stream();
		//stream의 모든 값 출력 / 매개변수는 참조 메소드 형식으로 변환하였음.forEach는 최종연산이라 실행 후 stream은 사라짐
		intStream.forEach(System.out::print);
		//재사용 원하는 경우 스트림 재생성 필요
		intStream = list.stream();
		intStream.forEach(System.out::print);
		System.out.println();
		
		//가변인자로 스트림 생성
		Stream<String> strStream = Stream.of("a","b","c");
		strStream.forEach(System.out::println);
		
		//배열로 스트림 생성
		Stream<String> strStream1 = Stream.of(new String[] {"a","b","c"});
		strStream1.forEach(System.out::println);
		
		//Arrays를 이용하여 스트림생성
		String[] strArr = {"가","나","다","라"};
		Stream<String> strStream2 = Arrays.stream(strArr);
		strStream2.forEach(System.out::println);
		
		//int배열을 String으로 변환
		//기본형 스트림과 객체형 스트림의 차이를 하기 코드 참고
		int[] intArr = {1,2,3,4,5}; //기본형 스트림
		IntStream intStream1 = Arrays.stream(intArr); // 자료형을 IntStream으로만 스트림 생성 가능
		
		//기본형으로 스트림생성시 count외에도 sum, average 등 유용한 함수가 많음
		System.out.println("count = "+intStream1.average()); 
		
		//객체형으로 스트림 생성시 count메소드만 사용 가능
		Integer[] intArr2 = {1,2,3,4,5}; //객체 스트림
		Stream<Integer> intStream2 = Arrays.stream(intArr2); //객체스트림이라 Stream 타입으로 생성 가능 
		
	}

}
