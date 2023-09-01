package emspkg;

public class CourseDTO {
	private int id;
	private String name;
	private String start;
	private String end;
	private int profid;
	
	public CourseDTO() {
	}

	public CourseDTO(int id, String name, String start, String end, int profid) {
		super();
		this.id = id;
		this.name = name;
		this.start = start;
		this.end = end;
		this.profid = profid;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public int getProfid() {
		return profid;
	}
}
