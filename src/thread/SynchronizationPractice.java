package thread;

class Account{
	private int balance = 1000;
	public int getBalance() {
		return balance;
	}
	public synchronized void withdraw(int money) { //synchronized로 메서드 동기화시킴
		//만약 동기화가 안되있다면 쓰레드가 실행중 money가 빠져나가 잔고가 음수로 나올 가능성이 생김(if문이 통과되었기 때문)
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			balance -=money;
		}
	}
}

class AccountRun implements Runnable{
	Account	acc = new Account();
	
	public void run() {
		while (acc.getBalance()>0) {
			//100,200,300중에 랜덤으로 선택하여 출금함
			int money = (int)(Math.random()*3+1)*100;
			acc.withdraw(money);
			System.out.println("balance : "+ acc.getBalance());
		}
	}
}

public class SynchronizationPractice {

	public static void main(String[] args) {
		Runnable r = new AccountRun();
		new Thread(r).start();
		new Thread(r).start();

	
}
}