package stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MakeRandomStream {

	public static void main(String[] args) {
		//난수 스트림 생성
		IntStream intStream = new Random().ints();
		//난수 5개만 출력. limit를 안하면 끝없이 출력됨
		intStream.limit(3).forEach(System.out::println);
		
		//ints에 값을 주면 limit의 효과를 줄 수 있음
		IntStream intStream2 = new Random().ints(5);
		intStream2.forEach(System.out::println);
		
		//ints에 숫자 범위를 지정 가능
		IntStream intStream3 = new Random().ints(1,100); //1~99까지의 난수 생성
		intStream3.limit(5).forEach(System.out::println);
	}

}
