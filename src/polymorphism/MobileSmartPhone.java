package polymorphism;

class MobilePhone {
	/*필드는 전부 private 처리로 인해 getter / setter 사용 해야함
	 * 
	 * 
	 */
	
	
	//필드
	private String model; //기종명
	public String number; //전화번호
	private String color; //색상
	
	//생성자
	public MobilePhone(String model, String number, String color){
		this.model=model;
		this.number=number;
		this.color=color;
	}
	//메소드

	public void receive () {
		System.out.println("Hi~from "+this.number);
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}//MobilePhone 클래스

class SmartPhone extends MobilePhone {
	//필드
	private boolean wifi;
	private String company;
	private String androidVer;
	
	//생성자
	//부모 생성자가 먼저 생성이 된후 자식 생성자가 만들어 져야 함
	
	
	public SmartPhone(String model, String number, String color, String company, String androidVer) {
		super(model,number,color); // 슈퍼 생성자를 이욯해 부모 생성자의 매개변수를 받아줌. 이때 자식 생성자 매개변수에 부모 생성자 매개변수 다 입력 해 줘야함
		this.company=company;
		this.androidVer=androidVer;
	
	//메소드
		
	}
	@Override
	public void receive() {
		System.out.println("스마트폰으로 전화받는다아");
	}
	public void send (String number){
		System.out.println("Hello ~ to "+ number);
	}

	public void playApp() {
		System.out.println(androidVer+"버전의 OS에서 어플이 작동합니다.");
	}
	
	public boolean isWifi() {
		return wifi;
	}
	
	public boolean setWifi(boolean wifi) {
		return this.wifi=wifi;
	}
	
} //SmartPhone 클래스 

public class MobileSmartPhone {
	public static void main(String[] args) {
		
		//스마트폰 객체생성
		SmartPhone sp = new SmartPhone("아이폰","010-2940-0649","스페이스 그레이","애플","ios14.1");
		
		//부모클래스의 참조 변수는 자식 클래스의 인스턴스를 참조할 수 있다.
		//객체는 SmartPhone의 객체를 가져오지만, 사용할 수 있는 멤버는 MobilePhone에서 정의된 멤버만 사용 가능함
		MobilePhone mp = new SmartPhone("갤럭시","010-7266-3228","흰색","삼성","안드로이드2");
		
		sp.setWifi(true); // SmartPhone 타입 변수이므로, SmartPhone의 멤버를 사용 가능
//		mp.setWife(); // 똑같은 SmartPhone 객체를 사용하지만, 타입이 MobilePhone 이며, 해당 클래스에 setWife가 없기 때문에 사용 불가함
		sp.receive(); // 오버라이드 한 형태로 출력
		mp.receive(); // MobilePhone에서 정의된 메소드가아닌, 실제 객체는 SmartPhone 이기 떄문에 오버라이드 된 메소드로 호출됨
		
		
		
		System.out.println("1번호 ="+sp.number);
		System.out.println("2번호 ="+mp.number);
		
		//전화걸기
		sp.send("010-6540-9805");
		//전화받기
		sp.receive();
		//앱을 선택하여 실행하기
		sp.playApp();
		mp.receive();
		
		
	}
	
}
