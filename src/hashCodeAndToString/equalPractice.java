package hashCodeAndToString;

class Value {
	int value;
	
	Value(int value){
		this.value = value;
	}

	//객체 주소가 아닌 객체의 iv를 비교하도록 오버라이딩
	public boolean equals(Object obj) {
		//return this == obj; -> 주소 비교. 서로 다른 객체는 다른 주소를 갖기때문에 항상 거짓
		if(!(obj instanceof Value)) {
			return false;
		}
		Value v = (Value)obj;
		return this.value==v.value;

	}
	
}

public class equalPractice {

	public static void main(String[] args) {

		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		System.out.println(v1.equals(v2));
	}

}
