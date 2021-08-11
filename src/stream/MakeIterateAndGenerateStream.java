package stream;

import java.util.stream.Stream;

public class MakeIterateAndGenerateStream {

	public static void main(String[] args) {

		//iterate를 이용해 짝수 스트림 생성 (단항 연산자라 매개변수 하나 넣으면 하나의 값만 출력)
		Stream<Integer> evenStream = Stream.iterate(0, n->n+2);
		evenStream.limit(5).forEach(System.out::print); //0,2,4,6,8 생성
		System.out.println();
		//generate를 이용 1 출력 (Supplier s) 이기 떄문에 매개변수 받지 않고 출력만 함
		Stream<Integer> oneStream = Stream.generate(()->1);
		oneStream.limit(5).forEach(System.out::print); //1,1,1,1,1 생성
		
	}

}
