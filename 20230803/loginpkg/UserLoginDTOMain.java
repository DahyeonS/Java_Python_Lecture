package loginpkg;

import java.util.Scanner;

public class UserLoginDTOMain {
	
	public static void main(String[] args) {
		/*
		UserLoginUseDTO user = new UserLoginUseDTO("a");
		UserDTO dto = user.getUser();
		System.out.println(dto);
		*/
		
		String id = "";
		String password = "";
		String role = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Admin or User? (a/u) > ");
		role = sc.next();
		System.out.print("ID > ");
		id = sc.next();
		System.out.print("Password > ");
		password = sc.next();
		
		if(role.equals("a") || role.equals("u")) {
			UserLoginUseDTO userLoginUseDTO = new UserLoginUseDTO(role);
			UserDTO user = new UserDTO(id, password);
			boolean rs = userLoginUseDTO.isLogin(user);
			System.out.println("Login: " + rs);
		} else {
			System.out.println("Login Fail - step 3");
		}		
		sc.close();
	}

}
