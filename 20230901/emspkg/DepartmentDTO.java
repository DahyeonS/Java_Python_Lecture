package emspkg;

public class DepartmentDTO {
	private int id;
	private String name;
	
	public DepartmentDTO() {
	}
	
	public DepartmentDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "학과 ID: " + id + " / 학과명: " + name;
	}
}
