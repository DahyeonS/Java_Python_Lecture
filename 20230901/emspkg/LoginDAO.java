package emspkg;

public interface LoginDAO {
	
	void LoginInsert(LoginDTO login);
	void LoginDelete(int index);
	
	int LoginIndex(String id);
}
