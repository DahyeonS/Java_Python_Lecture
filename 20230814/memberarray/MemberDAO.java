package memberarray;

public interface MemberDAO {
	
	int memberIndex(String id);
	MemberDTO[] memberList();
	MemberDTO[] memberList(String name);
	void memberInsert(MemberDTO member);
	void memberUpdate(int index, MemberDTO member);
	void memberDelete(int index);
	int memberNameIndex(String name);
	MemberDTO memberNameDTO(String name);
	
}
