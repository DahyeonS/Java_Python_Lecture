package genericpkg;

import java.util.ArrayList;
import java.util.List;

public class MemberNoGen {
	
	public static void main(String[] args) {
		List list = new ArrayList();
		Member mem1 = new Member();
		mem1.setId("hong");
		mem1.setPassword("1111");
		mem1.setName("홍길동");
		mem1.setAge(30);
		
		Member mem2 = new Member("kim", "2222", "김유신", 50);
		
		String id = "lee";
		String password = "3333";
		String name = "이순신";
		int age = 60;
		Member mem3 = new Member(id, password, name, age);
		list.add(mem1);
		list.add(mem2);
		list.add(mem3);
		
		for (int i=0; i<list.size(); i++) {
			Member m = (Member)(list.get(i));
			System.out.print("index: " + i + " / ");
			System.out.print("id: " + m.getId() + " / ");
			System.out.print("password: " + m.getPassword() + " / ");
			System.out.print("name: " + m.getName() + " / ");
			System.out.print("age: " + m.getAge() + " / ");
			System.out.println();
		}
		for (Object o : list) {
			Member m = (Member)o;
			System.out.print("id: " + m.getId() + " / ");
			System.out.print("password: " + m.getPassword() + " / ");
			System.out.print("name: " + m.getName() + " / ");
			System.out.print("age: " + m.getAge() + " / ");
			System.out.println();
		}
	}
	
}
