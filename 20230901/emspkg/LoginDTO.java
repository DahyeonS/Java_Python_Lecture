package emspkg;

public class LoginDTO {
	private String id;
	private String pw;
	
	public LoginDTO() {
	}

	public LoginDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}
}
