package stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamSort {

	public static void main(String[] args) {

		Stream<Student> studentStream = Stream.of(
				new Student("전송연",3,300),
				new Student("권순찬",2,250),
				new Student("주은표",1,150),
				new Student("최명규",2,200),
				new Student("최재석",1,200),
				new Student("정목조",3,300),
				new Student("김희철",2,100)
				);
		
		studentStream.sorted(Comparator.comparing(Student::getBan) //반별 정렬
		.thenComparing(Comparator.naturalOrder())) //추가 정렬 기준 제공 (기본 정렬로 변경)
		.forEach(System.out::println);
		
	}

}

class Student implements Comparable<Student>{
	String name;
	int ban;
	int totalScore;
	
	Student(String name, int ban, int totalScore) {
		this.name=name;
		this.ban=ban;
		this.totalScore=totalScore;
	}
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}
	String getName() {return name;}
	int getBan() {return ban;}
	int getTotalScore() {return totalScore;}
	
	
	//총점을 내림차순으로 정렬
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}