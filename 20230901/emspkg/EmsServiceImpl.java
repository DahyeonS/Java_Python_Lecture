package emspkg;

import java.util.List;
import java.util.Scanner;

public class EmsServiceImpl implements EmsService {
	private EmsDAO dao;
	private boolean check;
	
	public EmsServiceImpl() {
		this.dao = new EmsDAOImpl();
	}

	@Override
	public void InsertDepartment(Scanner sc) {
		System.out.println("1. 학과 추가");
		System.out.print("추가할 학과 ID를 입력하세요. > ");
		int id = sc.nextInt();
		System.out.print("추가할 학과 이름을 입력하세요. > ");
		String name = sc.next();
		
		DepartmentDTO dto = new DepartmentDTO(id, name);
		check = dao.SearchDepartment(dto);
		if (check) System.out.println("학과를 추가할 수 없습니다.");
		else {
			dao.InsertDepartment(dto);
			System.out.println("학과 추가 완료!");
		}
		List<DepartmentDTO> deptList = dao.DepartmentList();
		System.out.println("<학과 목록>");
		System.out.println("================================");
		for (DepartmentDTO d : deptList) {
			System.out.println(d.toString());
			System.out.println("================================");
		}
	}

	@Override
	public void InsertStudent(Scanner sc) {
		System.out.println("2. 학생 추가");
		System.out.print("추가할 학생 ID를 입력하세요. > ");
		int id = sc.nextInt();
		check = dao.CheckStudentId(id);
		
		if (check) System.out.println("학생을 추가할 수 없습니다.");
		else {
			System.out.print("추가할 학생 이름을 입력하세요. > ");
			String name = sc.next();
			System.out.print("추가할 신장을 입력하세요. > ");
			int height = sc.nextInt();
			
			System.out.print("추가할 학과 번호를 입력하세요. > ");
			int deptid = sc.nextInt();
			check = dao.CheckDeptId(deptid);
			
			if (check) {
				StudentDTO dto = new StudentDTO(id, name, height, deptid);
				dao.InsertStudent(dto);
				System.out.println("학생 추가 완료!");
			}
			else System.out.println("존재하지 않는 학과입니다.");
		}
		dao.StudentList();
	}

	@Override
	public void InsertProfessor(Scanner sc) {
		System.out.println("3. 교수 추가");
		System.out.print("추가할 교수 ID를 입력하세요. > ");
		int id = sc.nextInt();
		check = dao.CheckProfessorID(id);
		
		if (check) System.out.println("교수를 추가할 수 없습니다.");
		else {
			System.out.print("추가할 교수 이름을 입력하세요. > ");
			String name = sc.next();
			
			System.out.print("추가할 학과 번호를 입력하세요. > ");
			int deptid = sc.nextInt();
			check = dao.CheckDeptId(deptid);
			
			if (check) {
				ProfessorDTO dto = new ProfessorDTO(id, name, deptid);
				dao.InsertProfessor(dto);
				System.out.println("교수 추가 완료!");
			}
			else System.out.println("존재하지 않는 학과입니다.");
		}
		dao.ProfessorList();
	}

	@Override
	public void InsertCourse(Scanner sc) {
		System.out.println("4. 과목 추가");
		System.out.print("추가할 과목 ID를 입력하세요. > ");
		int id = sc.nextInt();
		check = dao.CheckCourseID(id);
		
		if (check) System.out.println("과목을 추가할 수 없습니다.");
		else {
			System.out.print("추가할 과목 이름을 입력하세요. > ");
			String name = sc.next();
			System.out.print("개강날짜를 입력하세요. (\"YYYY-MM-DD\" 형식) > ");
			String start = sc.next();
			System.out.print("종강날짜를 입력하세요. (\"YYYY-MM-DD\" 형식) > ");
			String end = sc.next();
			
			System.out.print("추가할 교수 번호를 입력하세요. > ");
			int profid = sc.nextInt();
			check = dao.CheckProfessorID(profid);
			
			if (check) {
				CourseDTO dto = new CourseDTO(id, name, start, end, profid);;
				dao.InsertCourse(dto);
				System.out.println("과목 추가 완료!");
			}
			else System.out.println("존재하지 않는 교수입니다.");
		}
		dao.CourseList();
	}

	@Override
	public void RegisterCourse(Scanner sc) {
		System.out.println("5. 수강 신청");
		System.out.print("학생 ID를 입력하세요. > ");
		int sid = sc.nextInt();
		check = dao.CheckStudentId(sid);
		
		if (check) {
			dao.CourseList();
			
			System.out.print("수강할 과목의 ID를 입력하세요. > ");
			int cid = sc.nextInt();
			check = dao.CheckCourseID(cid);
			
			if (check) {
				RegisterDTO dto = new RegisterDTO(sid, cid);
				check = dao.CheckRegister(dto);
				if (check) System.out.println("이미 신청한 과목입니다.");
				else {
					dao.RegisterCourse(dto);
					System.out.println("수강 신청 완료!");
				}
			}
			else System.out.println("존재하지 않는 과목입니다.");
			dao.RegisterList(sid);
		}
		else System.out.println("존재하지 않는 학생입니다.");
	}
	
	
}
