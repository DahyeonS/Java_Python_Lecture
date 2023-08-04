package loginpkg;

import java.util.Arrays;

public class UserData {
	private String[] adminData;
	private String[] userData;
	
	private static UserData instance = new UserData();
	
	private UserData() {
		adminData = new String[3];
		adminData[0] = "root";
		adminData[1] = "1111";
		adminData[2] = "admin";
		
		userData = new String[3];
		userData[0] = "hong";
		userData[1] = "2222";
		userData[2] = "user";	
	}

	public String[] getAdminData() {
		return adminData;
	}

	public String[] getUserData() {
		return userData;
	}

	public static UserData getInstance() {
		return instance;
	}

	@Override
	public String toString() {
		return "UserData [adminData=" + Arrays.toString(adminData) + ", userData=" + Arrays.toString(userData) + "]";
	}
}
