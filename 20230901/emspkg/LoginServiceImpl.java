package emspkg;

import java.util.List;
import java.util.Scanner;

public class LoginServiceImpl implements LoginService {
	private LoginDAO dao;
	
	public LoginServiceImpl() {
		this.dao = new LoginDAOImpl();
	}

	@Override
	public void LoginInsert(Scanner sc) {
		System.out.println("1. 회원 가입");
		System.out.print("ID 입력 > ");
		String id = sc.next();
		int index = dao.LoginIndex(id);
		
		if (index >= 0) System.out.println("이미 존재하는 회원입니다.");
		else {
			System.out.print("비밀번호 입력 > ");
			String pw = sc.next();
			LoginDTO login = new LoginDTO(id, pw);
			dao.LoginInsert(login);
			
			System.out.println(id + "님 회원가입 완료!");
		}
	}

	@Override
	public void LoginDelete(Scanner sc) {
		System.out.println("3. 회원 탈퇴");
		System.out.print("삭제할 ID 입력 > ");
		String id = sc.next();
		int index = dao.LoginIndex(id);
		
		if (index >= 0) {
			List<LoginDTO> loginList = LoginData.loginList;
			System.out.print("비밀번호 확인 > ");
			String pw = sc.next();
			
			if (pw.equals(loginList.get(index).getPw())) {
				dao.LoginDelete(index);
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
		System.out.println("2. 로그인");
		System.out.print("ID 입력 > ");
		String id = sc.next();
		System.out.print("비밀번호 입력 > ");
		String pw = sc.next();
		int index = dao.LoginIndex(id);
		
		if (index > -1) {
			List<LoginDTO> loginList = LoginData.loginList;
			
			if (pw.equals(loginList.get(index).getPw())) return true;
		}
		return false;
	}
	
}
