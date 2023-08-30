package memberdb;

import java.util.List;
import java.util.Scanner;

interface MemberService {
	
//	Member 목록 R
	List<MemberDTO> memberList();
//	Member 입력 C
	void memberInsert(Scanner sc);
//	Member 수정 U
	void memberUpdate(Scanner sc);
//	Member 삭제 D
	void memberDelete(Scanner sc);
	
}
