package loginpkg;

import java.util.Arrays;
import java.util.Scanner;

public class UserLoginMain {

	public static void main(String[] args) {
		/*
		UserData userData = UserData.getInstance();
		String[] a = userData.getAdminData();
		String[] u = userData.getUserData();
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(u));
		
		String id = a[0];
		String password = u[0];
		UserDTO user = new UserDTO(id, password);
		System.out.println(user);
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
			UserLogin userLogin = new UserLogin(role);
			boolean rs = userLogin.isLogin(id, password, role);
			System.out.println("Login: " + rs);
		} else {
			System.out.println("Login Fail - step 3");
		}		
		sc.close();
		
	}

}
