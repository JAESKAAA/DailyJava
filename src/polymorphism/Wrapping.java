package polymorphism;

class Box{
	public void simpleWrap() {
		System.out.println("Simple Wrapping");
	}
}

class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("Paper Wrapping");
	}
}

class GoldPaperBox extends PaperBox {
	public void goldWrap() {
		System.out.println("Gold Wrapping");
	}
}

public class Wrapping {

	public static void main(String[] args) {

		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
		
	}
	public static void wrapBox(Box box) {
		if(box instanceof GoldPaperBox) {
			System.out.println("GoldPaperBox형 입니다.");
			((GoldPaperBox) box).goldWrap();
		} else if (box instanceof PaperBox) {
			System.out.println("PaperBox형 입니다.");
			((PaperBox) box).paperWrap();
		} else if (box instanceof Box){
			System.out.println("Box형 입니다.");
			box.simpleWrap();
		}else {
//			System.out.println("Object 또는 String 타입일 가능성이 높습니다.");
		}
		
	}
}
