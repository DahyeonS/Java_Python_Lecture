package memberarray;

import java.util.Scanner;

interface MemberService {
	
//	Member 목록 R
	MemberDTO[] memberList();
	MemberDTO[] memberList(Scanner sc);
//	Member 이름 검색 1명 R
	int memberOne(Scanner sc);
//	Member 이름 검색 R
	MemberDTO memberDTOOne(Scanner sc);
//	Member 입력 C
	void memberInsert(Scanner sc);
//	Member 수정 U
	void memberUpdate(Scanner sc);
//	Member 삭제 D
	void memberDelete(Scanner sc);
	
}
