package memberfile;

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
			System.out.println("5. 회원 이름으로 검색(index)");
			System.out.println("6. 회원 이름으로 검색(DTO)");
			System.out.println("7. 회원 이름으로 모두 검색");
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
				case 5 :
					int index = service.memberOne(sc);
					if (index >= 0) {
						MemberView.memberPrint(index);
					} else {
						System.out.println("회원이 없습니다.");
					}
					break;
				case 6 :
					MemberDTO m = service.memberDTOOne(sc);
					if (m != null) {
						MemberView.memberPrint(m);
					} else {
						System.out.println("회원이 없습니다.");
					}
					break;
				case 7 :
					List<MemberDTO> member = service.memberList(sc);
					if (member != null) {
						MemberView.memberPrint(member);
					} else {
						System.out.println("회원이 없습니다.");
					}
					break;
			}
//			End
			if (command == 9) break;
		}
		sc.close();
	}

}
