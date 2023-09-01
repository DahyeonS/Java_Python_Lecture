package emspkg;

import java.util.Scanner;

public class emsMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		
		while (true) {
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 탈퇴");
			System.out.println("9. 종료");
			System.out.print(">> ");
			
			int command = sc.nextInt();
			LoginService loginservice = new LoginServiceImpl();
			
			switch (command) {
				case 1 : 
					loginservice.LoginInsert(sc);
					break;
					
				case 2 :
					check = loginservice.Login(sc);
					
					if (check) command = 9;
					else System.out.println("로그인 실패");
					break;
				
				case 3 :
					loginservice.LoginDelete(sc);
					break;
					
			}
			if (command == 9) break;
		}
		
		while (check) {
			System.out.println("== 학사 관리 ==");
			System.out.println("1. 학과 추가");
			System.out.println("2. 학생 추가");
			System.out.println("3. 교수 추가");
			System.out.println("4. 과목 추가");
			System.out.println("5. 수강 신청");
			System.out.println("9. 끝내기");
			System.out.print(">> ");
			
			int command = sc.nextInt();
			emsService service = new emsServiceImpl();
			
			switch (command) {
			case 1 : 
				service.InsertDepartment(sc);
				break;
				
			case 2 :
				System.out.println("2. 학생 추가");
				break;
			
			case 3 :
				System.out.println("3. 교수 추가");
				break;
				
			case 4 :
				System.out.println("4. 과목 추가");
				break;
				
			case 5 :
				System.out.println("5. 수강 신청");
				break;
			}
			if (command == 9) break;
		}
		sc.close();
	}

}
