package emspkg;

public class RegisterDTO {
	private int sid;
	private int cid;
	
	public RegisterDTO() {
	}

	public RegisterDTO(int sid, int cid) {
		super();
		this.sid = sid;
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public int getCid() {
		return cid;
	}
	
}
