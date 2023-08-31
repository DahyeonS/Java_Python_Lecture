package jdbcpkg;

import java.util.List;

public interface MemberService {
	MemberDTO getMemberOne(String id);
	MemberDTO getMemberOneName(String name);
	List<MemberDTO> getMemberList();
	void insertMember(MemberDTO dto);
	void updateMember(MemberDTO dto);
	void deleteMember(MemberDTO dto);
	void searchMemberOne(MemberDTO dto);
	void searchMemberList(MemberDTO dto);
}
