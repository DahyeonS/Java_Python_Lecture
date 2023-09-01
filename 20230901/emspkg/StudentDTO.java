package emspkg;

public class StudentDTO {
	private int id;
	private String name;
	private int height;
	private int deptid;
	
	public StudentDTO() {
	}

	public StudentDTO(int id, String name, int height, int deptid) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.deptid = deptid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	@Override
	public String toString() {
		return "학생 ID: " + id + " / 학생이름: " + name + " / 신장: " + height + " / 학과 ID: " + deptid;
	}
	
	
}
