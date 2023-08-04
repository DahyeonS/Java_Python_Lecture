package loginpkg;

public class UserLogin {
	private String id;
	private String password;
	private String role;
	
	public UserLogin(String role) {
		String[] data = null;
		UserData userData = UserData.getInstance();
		
		if (role.equals("a")) {
			data = userData.getAdminData();
		} else if (role.equals("u")) {
			data = userData.getUserData();
		}
		this.id = data[0];
		this.password = data[1];
		this.role = data[2];
	}
	
	boolean isLogin(String id, String password, String role) {
//		System.out.println(id);
//		System.out.println(password);
//		System.out.println(role);
		boolean rs = false;
		if (id.equals(this.id)) {
			if (password.equals(this.password)) {
				System.out.printf("Welcome!! %s(%s) \n", id, role);
				rs = true;
			} else {
				System.out.println("Login Fail - step 2");
			}
		} else {
			System.out.println("Login Fail - step 1");
		}
		return rs;
	}

	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
