package memberarray;

import java.util.Arrays;
import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("== 메뉴 선택 ==");
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원 목록 보기");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 회원 이름으로 검색");
			System.out.println("9. 끝내기");
			
//			String command = sc.next();
			int command = sc.nextInt();
			MemberService service = new MemberServiceImpl();
			
//			Start
//			switch (Integer.parseInt(command)) {
			switch (command) {
				case 1 :
					service.memberInsert(sc);
					break;
				case 2 :
					System.out.println("2. 회원 목록 보기");
					MemberDTO[] members = service.memberList();
					MemberView.memberPrint(members);
					break;
				case 3 :
					service.memberUpdate(sc);
					break;
				case 4 :
					service.memberDelete(sc);
					break;
				case 5 :
					service.memberSearch(sc);
					break;
			}
//			End
//			if (command.equals("9")) break;
			if (command == 9) break;
			/*
			if (command.equals("1")) System.out.println("1. 회원 가입");
			else if (command.equals("2")) System.out.println("2. 회원 목록 보기");
			else if (command.equals("3")) System.out.println("3. 회원 정보 수정");
			else if (command.equals("4")) System.out.println("4. 회원 삭제");
			else if (command.equals("9")) break;
			 */
			
		}
		sc.close();
	}

}
