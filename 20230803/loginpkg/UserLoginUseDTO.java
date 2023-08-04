package loginpkg;

public class UserLoginUseDTO {
	private UserDTO user;
	
	public UserLoginUseDTO(String role) {
//		기존과 동일
		String[] data = null;
		UserData userData = UserData.getInstance();
		
		if (role.equals("a")) {
			data = userData.getAdminData();
		} else if (role.equals("u")) {
			data = userData.getUserData();
		}
//		String id = data[0];
//		String password = data[1];
//		role = data[2];
//		this.user = new UserDTO(id, password, role);
		this.user = new UserDTO(data[0], data[1], data[2]);
	}
	
	public UserDTO getUser() {
		return user;
	}
	
	boolean isLogin(UserDTO user) {
		boolean rs = false;
//		기존과 동일
		if (user.getId().equals(this.user.getId())) {
			if (user.getPassword().equals(this.user.getPassword())) {
				System.out.printf("Welcome!! %s(%s) \n", this.user.getId(), this.user.getRole());
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
		return this.user.toString();
	}
}
