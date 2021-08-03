package hashCodeAndToString;

import java.util.Objects;

class Card {
	String kind;
	int number;
	
	Card(){
		this("SPADE",1);
	}
	Card(String kind, int number){
		this.kind=kind;
		this.number=number;
	}
	
	public String toString() {
		return "kind = "+kind+" number = "+ number; // 오버라이딩 전에는 주소값을 반환했지만, iv값을 가리키도록 오버라이딩 하여 정상 출력
	}
	
	public int hashCode() {
		return Objects.hash(kind,number); //Objects의 hash()는 매개변수가 가변인자라 여러게의 iv값을 넣어도 무방함
	}
	
	//equals를 오버라이딩 하면 hashCode도 오버라이딩 해야한다.
	public boolean equals(Object obj) {
		if(!(obj instanceof Card)) 
			return false;
		
		Card c = (Card)obj;
		return this.kind.equals(c.kind) && this.number==c.number;
		}
}

public class practice {

	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();
		
		System.out.println(c1.hashCode()); //해쉬코드가 같음
		System.out.println(c2.hashCode());
		
		System.out.println(c1==c2);
		System.out.println(c1.equals(c2));
	}

}
