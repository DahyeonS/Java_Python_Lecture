package exceptionpkg;

import java.util.Scanner;

public class LoginExceptionMain {
	static String userId = "hong";
	static String userPw = "1234";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("ID > ");
			String inputId = sc.next();
			System.out.print("PW > ");
			String inputPw = sc.next();
			if (!userId.equals(inputId)) {
				throw new LoginException("아이디가 틀립니다.");
			} else if (!userPw.equals(inputPw)) {
				throw new LoginException("비밀번호가 틀립니다.");
			} else {
				System.out.println("로그인 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
