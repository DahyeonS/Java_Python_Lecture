package emspkg;

import java.util.Scanner;

public class LoginServiceImpl implements LoginService {
	private LoginDAO dao;
	
	public LoginServiceImpl() {
		this.dao = new LoginDAOImpl();
	}

	@Override
	public void LoginInsert(Scanner sc) {
		System.out.println("2. 회원 가입");
		System.out.print("ID 입력 > ");
		String id = sc.next();
		boolean check = dao.LoginIndex(id);
		
		if (check) System.out.println("이미 존재하는 회원입니다.");
		else {
			System.out.print("비밀번호 입력 > ");
			String pw = sc.next();
			LoginDTO dto = new LoginDTO(id, pw);
			dao.LoginInsert(dto);
			
			System.out.println(id + "님 회원가입 완료!");
		}
	}

	@Override
	public void LoginDelete(Scanner sc) {
		System.out.println("3. 회원 탈퇴");
		System.out.print("삭제할 ID 입력 > ");
		String id = sc.next();
		boolean check = dao.LoginIndex(id);
		
		if (check) {
			System.out.print("비밀번호 확인 > ");
			String pw = sc.next();
			
			if (pw.equals(dao.PwCheck(id))) {
				LoginDTO dto = new LoginDTO(id, pw);
				dao.LoginDelete(dto);
				System.out.println(id + "님 회원탈퇴 완료!");
			}
			else System.out.println("비밀번호가 틀립니다");
		}
		else {
			System.out.println("Member Not Found!!");
		}
	}

	@Override
	public boolean Login(Scanner sc) {
		System.out.println("1. 로그인");
		System.out.print("ID 입력 > ");
		String id = sc.next();
		System.out.print("비밀번호 입력 > ");
		String pw = sc.next();
		
		LoginDTO dto = new LoginDTO(id, pw);
		
		return dao.Login(dto);
	}
	
}
