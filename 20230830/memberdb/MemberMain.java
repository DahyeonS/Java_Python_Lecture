package memberdb;

import java.util.List;
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
			System.out.println("9. 끝내기");
			
			int command = sc.nextInt();
			MemberService service = new MemberServiceImpl();
			
//			Start
			switch (command) {
				case 1 :
					service.memberInsert(sc);
					break;
				case 2 :
					System.out.println("2. 회원 목록 보기");
					List<MemberDTO> members = service.memberList();
					MemberView.memberPrint(members);
					break;
				case 3 :
					service.memberUpdate(sc);
					break;
				case 4 :
					service.memberDelete(sc);
					break;
			}
//			End
			if (command == 9) break;
		}
		sc.close();
	}

}
