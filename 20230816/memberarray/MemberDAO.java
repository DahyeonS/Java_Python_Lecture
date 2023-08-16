package memberarraylist;

import java.util.List;

public interface MemberDAO {
	
	int memberIndex(String id);
	List<MemberDTO> memberList();
	List<MemberDTO> memberList(String name);
	void memberInsert(MemberDTO member);
	void memberUpdate(int index, MemberDTO member);
	void memberDelete(int index);
	int memberNameIndex(String name);
	MemberDTO memberNameDTO(String name);
	
}
