package CrudProject2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class Person {
	private String name;
	private int num;

	public Person(String name, int num) {
		this.name = name;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return getName() + "," + getNum();
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person person = (Person) obj;
			return person.name.equals(name) && (person.num == num);
		} else {
			return false;
		}
	}

}

public class praac {
	public static Set<Person> set = new HashSet<>();
	static Scanner sc = new Scanner(System.in);
	public static Iterator<Person> it =set.iterator();
	public static void main(String[] args) {
		String name = "";

		set.add(new Person("홍길동", 31));
		set.add(new Person("이순신", 30));
		set.add(new Person("장영실", 29));
		set.add(new Person("김두환", 38));

		System.out.println(set);
		
		Person p = itr();
		//관건은 김두환2로 바뀐 객체를 셋.리무브가 어뜨케 잡아내게 할것이냐임
		 p.setName("김두환2");
				set.remove(p);
		System.out.println(set);
		
	}

	public static Person itr() {
		 it = set.iterator();
		System.out.println("조회하고 싶은 사람 이름>");
		String name = sc.nextLine();
		Person p = null;
		while (it.hasNext()) {
			p = it.next();
			if (p.getName().equals(name)) {
				System.out.println(p.getNum());
				return p;
			} else {

			}
		}
		return p;
	}
}
