package memberarray;

public interface MemberDAO {
	
	int memberIndex(String id);
	MemberDTO[] memberList();
	void memberInsert(MemberDTO member);
	void memberUpdate(int index, MemberDTO member);
	void memberDelete(int index);
	int memberNameIndex(String name);
	
}
