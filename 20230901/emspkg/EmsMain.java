package emspkg;

import java.util.Scanner;

public class EmsMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		
		while (true) {
			System.out.println("== 로그인 페이지 ==");
			System.out.println("1. 로그인");
			System.out.println("2. 회원 가입");
			System.out.println("3. 회원 탈퇴");
			System.out.println("9. 종료");
			System.out.print(">> ");
			
			int command = sc.nextInt();
			LoginService loginservice = new LoginServiceImpl();
			
			switch (command) {
				case 1 : 
					check = loginservice.Login(sc);
					
					if (check) {
						command = 9;
						System.out.println("환영합니다!");
					}
					else System.out.println("로그인 실패");
					break;
					
				case 2 :
					loginservice.LoginInsert(sc);
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
			EmsService service = new EmsServiceImpl();
			
			switch (command) {
			case 1 : 
				service.InsertDepartment(sc);
				break;
				
			case 2 :
				service.InsertStudent(sc);
				break;
			
			case 3 :
				service.InsertProfessor(sc);
				break;
				
			case 4 :
				service.InsertCourse(sc);
				break;
				
			case 5 :
				service.RegisterCourse(sc);
				break;
			}
			if (command == 9) break;
		}
		sc.close();
	}

}
