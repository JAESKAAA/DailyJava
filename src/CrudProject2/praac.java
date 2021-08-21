package CrudProject2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class Person{
	private String name;
	private int num;
	
	public Person(String name, int num) {
		this.name = name;
		this.num= num;
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
		return getName() +","+ getNum();
	}
	
	@Override
	public int hashCode() {
		return name.hashCode()+num;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person person = (Person) obj;
			return person.name.equals(name) && (person.num==num);
		} else {
			return false;
		}
	}
	
}

public class praac {
public static void main(String[] args) {
	Set<Person> set = new HashSet<>();
	
	Scanner sc = new Scanner(System.in);
	set.add(new Person("이종원",31));
	set.add(new Person("최재석",30));
	set.add(new Person("전송연",29));
	set.add(new Person("권순찬",38));
	
	
	
	System.out.println(set);
	
	Iterator<Person> it = set.iterator();
	while(it.hasNext()) {
		Person p = it.next();
			System.out.println("조회하고 싶은 사람 이름>");
			String name = sc.nextLine();
		if(p.getName().equals(name)) {
			System.out.println(p.getNum());
			break;
		} 
		
	}
	
	
}
}
