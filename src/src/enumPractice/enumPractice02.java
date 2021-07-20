package src.enumPractice;
enum Direction2 { 
	EAST(1, ">"), SOUTH(2,"V"), WEST(3, "<"), NORTH(4,"^");

	private static final Direction2[] DIR_ARR = Direction2.values();
	private final int value;
	private final String symbol;

	Direction2(int value, String symbol) { // 접근 제어자 private이 생략됨
		this.value  = value;
		this.symbol = symbol;
	}

	public int getValue()     { return value;  }
	public String getSymbol() { return symbol; }

	public static Direction2 of(int dir) {
        if (dir < 1 || dir > 4) //0~3을 벗어나면 하기 예외 발생하게 만듬
            throw new IllegalArgumentException("Invalid value :" + dir);

        return DIR_ARR[dir - 1]; //매개변수 값 -1 ex. EAST의 경우 1이니까 DIR_ARR[0]을 반환함
	}	

	// 방향을 회전시키는 메서드. num의 값만큼 90도씩 시계방향으로 회전한다.
	public Direction2 rotate(int num) {
		num = num % 4; //매개변수 받아서 4로 나눈 나머지 값을 num에 저장 ex) 매개 변수1 = num =1

		if(num < 0) num +=4; // num이 음수일 때는 시계반대 방향으로 회전 

		return DIR_ARR[(value-1+num) % 4]; //num이 1인 경우, value도 1이므로 (1-1+1) % 4 = 1. 따라서 DIR_ARR[1] 출력
	}

	public String toString() {
		return name()+getSymbol();
	}
} // enum Direction2

class enumPractice02 {
	public static void main(String[] args) {
		for(Direction2 d : Direction2.values()) 
			System.out.printf("%s=%d%n", d.name(), d.getValue()); 
		//                                         여기를 getValue 대신 ordinal 주게되면, EAST=1 ...이 아닌 EAST =0 부터 순차적으로 출력됨

		Direction2 d1 = Direction2.EAST;
		Direction2 d2 = Direction2.of(1);

		System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
		System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());
		System.out.println(Direction2.EAST.rotate(1));
		System.out.println(Direction2.EAST.rotate(2));
		System.out.println(Direction2.EAST.rotate(-1));
		System.out.println(Direction2.EAST.rotate(-2));
		
	}
}