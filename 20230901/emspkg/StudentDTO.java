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

	public String getName() {
		return name;
	}

	public int getHeight() {
		return height;
	}

	public int getDeptid() {
		return deptid;
	}
}
