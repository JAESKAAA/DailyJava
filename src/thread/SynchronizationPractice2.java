package thread;

import java.util.ArrayList;

/*
 * wait() 과 notify()를 이용하여 쓰레드 대기, 재실행 상황을 설정함.
 * 아직 흐름이 이해안가서 다시한번 봐야하는 코드
 */

class Customer2 implements Runnable {
	private Table2 table;
	private String food;

	Customer2(Table2 table, String food) {
		this.table = table;
		this.food = food;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
			// 현재 실행중인 쓰레드의 이름 반환
			String name = Thread.currentThread().getName();

			table.remove(food);
				System.out.println(name + " ate a" + food);
			}
		}
}

class Cook2 implements Runnable {
	private Table2 table;

	Cook2(Table2 table) {
		this.table = table;
	}

	public void run() {
		while (true) {
			int idx = (int) (Math.random() * table.dishNum());
			table.add(table.dishName[idx]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}

class Table2 {
	String[] dishName = { "donut", "dount", "burger" };
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {// 동기화 추가
		while (dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + "is waiting.");
			try {
				wait();
				Thread.sleep(500);
			} catch(InterruptedException e) {}
		}
		dishes.add(dish);
		notify(); // 기다리고 있는 CUST를 꺠우기 위함
		System.out.println("Dishes:" + dishes.toString());
	}

	public void remove(String dishName) {
		synchronized (this) {
			String name = Thread.currentThread().getName();

			while (dishes.size() == 0) {
				System.out.println(name + "is waiting.");
				try {
					wait();// CUST 쓰레드를 기다리게 만듬
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
			
			while (true) {
				for (int i = 0; i < dishes.size(); i++) {
					if (dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify(); // 잠자고있는 COOK을 깨움
						return;
					}
				}
				try {
					System.out.println(name+"is waiting.");
					wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
		}
	}
	public int dishNum() {return dishName.length;}
}

public class SynchronizationPractice2 {

	public static void main(String[] args) throws InterruptedException {
		Table2 table = new Table2();

		new Thread(new Cook2(table), "COOK1").start();
		new Thread(new Customer2(table, "donut"), "CUST1").start();
		new Thread(new Customer2(table, "burger"), "CUST2").start();
		Thread.sleep(2000);
		System.exit(0);

	}

}
