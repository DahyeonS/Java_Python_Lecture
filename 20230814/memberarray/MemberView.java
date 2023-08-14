package memberarray;

public class MemberView {
	static void memberPrint(MemberDTO[] members) {
		
		System.out.println("Member View");
		System.out.println("현재 회원 수: " + members.length);
		
		for (MemberDTO m : members) {
			System.out.print("ID: " + m.getId() + " / ");
			System.out.print("Password: " + m.getPw() + " / ");
			System.out.print("name: " + m.getName() + " / ");
			System.out.print("Age: " + m.getAge() + "\n");
			System.out.println("=======================================================");
		}
	}
}
