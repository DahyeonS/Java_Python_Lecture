package emspkg;

public class ProfessorDTO {
	private int id;
	private String name;
	private int deptid;
	
	public ProfessorDTO() {
	}

	public ProfessorDTO(int id, String name, int deptid) {
		super();
		this.id = id;
		this.name = name;
		this.deptid = deptid;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getDeptid() {
		return deptid;
	}
}
