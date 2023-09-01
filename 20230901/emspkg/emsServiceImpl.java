package emspkg;

import java.util.Scanner;

public class emsServiceImpl implements emsService {
	private DepartmentDAO dao;
	
	public emsServiceImpl() {
		this.dao = new DepartmentDAOImpl();
	}

	@Override
	public void InsertDepartment(Scanner sc) {
		System.out.println("1. 학과 추가");
		System.out.print("추가할 학과 ID를 입력하세요. > ");
		int id = sc.nextInt();
		System.out.print("추가할 학과 이름을 입력하세요. > ");
		String name = sc.next();
		
		DepartmentDTO dto = new DepartmentDTO(id, name);
		boolean check = dao.SearchDepartment(dto);
		if (check) System.out.println("학과를 추가할 수 없습니다.");
		else {
			dao.InsertDepartment(dto);
			System.out.println("학과 추가 완료!");
		}
		dao.DepartmentList();
	}
	
	
}
