package jdbcpkg;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MemberMain3 {
	
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("== 메뉴 선택 ==");
			System.out.println("1. 회원 목록 보기");
			System.out.println("2. 회원 가입");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 회원 이름으로 검색");
			System.out.println("6. 회원 이름으로 모두 검색");
			System.out.println("9. 끝내기");
			
			int command = sc.nextInt();
			
//			Start
			switch (command) {
				case 1 :
					System.out.println("1. 회원 목록 보기");
					
					List<MemberDTO> memberList = MemberStaticDAO.getMemberList();
					
//					Print
					for (MemberDTO m : memberList) {
						System.out.print(m.getId() + " / ");
						System.out.print(m.getPw() + " / ");
						System.out.print(m.getName() + " / ");
						System.out.println(m.getAge());
						System.out.println("================================");
					}
					break;
					
				case 2 :
					System.out.println("2. 회원 가입");
//					회원 정보 입력
					System.out.print("ID 입력 > ");
					String id = sc.next();
					System.out.print("Password 입력 > ");
					String pw = sc.next();
					System.out.print("Name 입력 > ");
					String name = sc.next();
					System.out.print("Age 입력 > ");
					int age = sc.nextInt();
					
					MemberDTO dto = new MemberDTO(id, pw, name, age);
					MemberStaticDAO.InsertMember(dto);
					break;
					
				case 3 :
					System.out.println("3. 회원 정보 수정");
//					회원 정보 입력
					System.out.print("ID 입력 > ");
					id = sc.next();
					dto = MemberStaticDAO.getMemberOne(id);
					
					if (dto != null) MemberStaticDAO.UpdateMember(dto);
					else System.out.println("Member Not Found!!");
					break;
					
				case 4 :
					System.out.println("3. 회원 정보 수정");
//					회원 정보 입력
					System.out.print("ID 입력 > ");
					id = sc.next();
					dto = MemberStaticDAO.getMemberOne(id);
					
					if (dto != null) {
//						수정 정보 입력
						System.out.println("기존 Password: " + dto.getPw());
						System.out.print("새로운 Password 입력 > ");
						pw = sc.next();
						System.out.println("기존 Name: " + dto.getName());
						System.out.print("새로운 Name 입력 > ");
						name = sc.next();
						System.out.println("기존 Age: " + dto.getAge());
						System.out.print("새로운 Age 입력 > ");
						age = sc.nextInt();
						
						dto = new MemberDTO(id, pw, name, age);
						MemberStaticDAO.UpdateMember(dto);
					}
					else System.out.println("Member Not Found!!");
					break;
					
				case 5 :
					System.out.println("5. 회원 이름으로 검색");
					
//					이름 입력으로 사용자가 있다면 검색
					System.out.print("이름 입력 > ");
					name = sc.next();
					
					dto = MemberStaticDAO.getMemberOneName(name);
					if (dto != null) MemberStaticDAO.SearchMemberOne(dto);
					else System.out.println("Member Not Found!!");
					break;
					
				case 6 :
					System.out.println("6. 회원 이름으로 모두 검색");
					
//					이름 입력으로 사용자가 있다면 검색
					System.out.print("이름 입력 > ");
					name = sc.next();
					
					dto = MemberStaticDAO.getMemberOneName(name);
					if (dto != null) MemberStaticDAO.SearchMemberList(dto);
					else System.out.println("Member Not Found!!");
					break;
			}
//			End
			if (command == 9) break;
		}
		sc.close();
	}

}