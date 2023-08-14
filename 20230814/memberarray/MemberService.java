package memberarray;

import java.util.Scanner;

interface MemberService {
	
//	Member 목록 R
	MemberDTO[] memberList();
//	Member 입력 C
	void memberInsert(Scanner sc);
//	Member 수정 U
	void memberUpdate(Scanner sc);
//	Member 삭제 D
	void memberDelete(Scanner sc);
	
//	Member 검색
	void memberSearch(Scanner sc);
}
