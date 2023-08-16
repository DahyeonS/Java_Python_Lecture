package memberarraylist;

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
	public List<MemberDTO> memberList(Scanner sc) {
		System.out.println("7. 회원 이름으로 모두 검색");
		System.out.println("검색할 이름 입력: ");
		String name = sc.next();
		return this.dao.memberList(name);
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
			List<MemberDTO> m = MemberArrayListData.members;
			System.out.println("현재 Password: " + m.get(index).getPw());
			System.out.print("수정할 Password 입력 > ");
			String pw = sc.next();
			System.out.println("현재 Name: " + m.get(index).getName());
			System.out.print("수정할 Name 입력 > ");
			String name = sc.next();
			System.out.println("현재 Age: " + m.get(index).getAge());
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
			dao.memberDelete(index);
			System.out.println(id + "님 정보 삭제 완료!");
		} else {
			System.out.println("Member Not Found!!");
			System.out.println("존재하지 않는 ID입니다.");
		}
	}

	@Override
	public int memberOne(Scanner sc) {
		System.out.println("5. 회원 이름으로 검색(index)");
		System.out.print("검색할 이름 입력 > ");
		String name = sc.next();
		int index = dao.memberNameIndex(name);
		return index;
	}

	@Override
	public MemberDTO memberDTOOne(Scanner sc) {
		System.out.println("6. 회원 이름으로 검색(DTO)");
		System.out.print("검색할 이름 입력 > ");
		String name = sc.next();
		MemberDTO member = dao.memberNameDTO(name);
		return member;
	}

}
