package memberdb;

import java.util.List;

public interface MemberDAO {
	
	int memberIndex(String id);
	List<MemberDTO> memberList();
	void memberInsert(MemberDTO member);
	void memberUpdate(int index, MemberDTO member);
	void memberDelete(String id);
	
}
