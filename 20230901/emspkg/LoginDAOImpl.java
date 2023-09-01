package emspkg;

import java.util.List;

public class LoginDAOImpl implements LoginDAO {
	List<LoginDTO> loginMember = LoginData.loginList;

	@Override
	public void LoginInsert(LoginDTO login) {
		loginMember.add(login);
	}

	@Override
	public int LoginIndex(String id) {
		for (int i=0; i<loginMember.size(); i++) {
			if (id.equals(loginMember.get(i).getId())) return i;
		}
		return -1;
	}

	@Override
	public void LoginDelete(int index) {
		loginMember.remove(index);
	}

}
