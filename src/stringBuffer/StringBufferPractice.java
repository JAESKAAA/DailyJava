package stringBuffer;

public class StringBufferPractice {

	public static void main(String[] args) {
		//StringBuffer 생성
		StringBuffer sb = new StringBuffer("01");
		//StringBuffer 인스턴스에 23을 추가
		StringBuffer sb2 = sb.append(23);
		sb.append(4).append(56);
		
		// String과 달리 StringBuffer는 변경이 가능하여 새로운 버퍼를 만드는것이 아닌 기존의 값을 변경후 똑같은 번지수를 반환함
		System.out.println(sb);
		System.out.println(sb2);
		//똑같은 값을 참조하기때문에 true를 반환함
		System.out.println(sb==sb2);
		
		StringBuffer sb3 = sb.append(78);
		sb3.append(9.0);
		//실수를 넣으면 9와.과0 모두 문자열로 처리되어서 길이가 3늘어남
		System.out.println(sb3);
		System.out.println(sb3.length());
		
		//10번 인덱스의 .을 지움
		System.out.println("deleteCharAt = "+ sb.deleteCharAt(10));
		System.out.println(sb.delete(3,6)); // 3~5번까지 삭제
		System.out.println(sb.insert(3, "abc")); // 3번인덱스에 abc문자열 삽입
		System.out.println(sb.replace(6, sb.length(), "end")); //6번 인덱스에서 마지막 인덱스까지를 지우고 end로 교체
		
		//StringBuffer 배열 크기
		System.out.println(sb.capacity());
		System.out.println(sb.length());

		//기본 배열의 크기는 16으로 설정됨
		StringBuffer ad = new StringBuffer();
		System.out.println(ad.capacity());
	}

}
