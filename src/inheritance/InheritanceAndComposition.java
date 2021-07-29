package inheritance;

class MyPoint {
	int x;
	int y; // 자동 초기화로 객체 생성시 0으로 채워질것 예상하기
}

class  Circle {//Circle 클래스에 MyPoint 클래스를 포함 시킨것. 
	MyPoint p = new MyPoint();
	int r;
}

public class InheritanceAndComposition { 
	public static void main(String[] args) {
		Circle c = new Circle(); // 힙영역에는 Circle와 MyPoint 인스턴스가 각각 생성되어있음 
		c.p.x = 1;
		c.p.y = 2;
		c.r = 5; // Circle에 있는  iv이기 때문에 c.r로 접근 함
		
			
	}

}
