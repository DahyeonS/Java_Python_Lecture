package memberdb;

import java.util.List;
import java.util.Scanner;

public class MemberServiceImpl implements MemberService {
	private MemberDAO dao;
	
	public MemberServiceImpl() {
		this.dao = new MemberDAOImpl();
	}
	
	@Override
	public List<MemberDTO> memberList() {
		return this.dao.memberList();
	}
	
	@Override
	public void memberInsert(Scanner sc) {
		System.out.println("1. 회원 가입");
		System.out.print("ID 입력 > ");
		String id = sc.next();
		int index = dao.memberIndex(id);
		if (index != -1) {
			System.out.println("중복된 아이디가 있습니다.");
		} else {
			System.out.print("Password 입력 > ");
			String pw = sc.next();
			System.out.print("Name 입력 > ");
			String name = sc.next();
			System.out.print("Age 입력 > ");
			int age = sc.nextInt();
			
			MemberDTO member = new MemberDTO(id, pw, name, age);
			dao.memberInsert(member);
		}
	}

	@Override
	public void memberUpdate(Scanner sc) {
		System.out.println("3. 회원 정보 수정");
//		수정할 대상
		System.out.print("수정할 ID 입력 > ");
		String id = sc.next();
		int index = dao.memberIndex(id);
		if (index >= 0) { // ID가 있으면
//			수정할 요소
			System.out.print("수정할 Password 입력 > ");
			String pw = sc.next();
			System.out.print("수정할 Name 입력 > ");
			String name = sc.next();
			System.out.print("수정할 Age 입력 > ");
			int age = sc.nextInt();
//			수정 데이터 처리
			MemberDTO member = new MemberDTO(id, pw, name, age);
			dao.memberUpdate(index, member);
			System.out.println(id + "님 정보 수정 완료!");
		} else { // ID가 없으면
			System.out.println("Member Not Found!!");
			System.out.println("존재하지 않는 ID입니다.");
		}
	}

	@Override
	public void memberDelete(Scanner sc) {
		System.out.println("4. 회원 삭제");
		System.out.print("삭제할 ID 입력 > ");
		String id = sc.next();
		int index = dao.memberIndex(id);
		if (index != -1) {
			dao.memberDelete(id);
			System.out.println(id + "님 정보 삭제 완료!");
		} else {
			System.out.println("Member Not Found!!");
			System.out.println("존재하지 않는 ID입니다.");
		}
	}

}
