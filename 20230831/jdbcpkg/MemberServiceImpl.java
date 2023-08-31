package jdbcpkg;

import java.util.List;

public class MemberServiceImpl implements MemberService {
	MemberDAO dao;
	
	public MemberServiceImpl() {
		this.dao = new MemberDAO();
	}

	public MemberDTO getMemberOne(String id) {
//		MemberDAO dao = new MemberDAO();
		return dao.getMemberOne(id);
	}
	
	public List<MemberDTO> getMemberList() {
//		MemberDAO dao = new MemberDAO();
		return dao.getMemberList();
	}
	
	public void insertMember(MemberDTO dto) {
//		MemberDAO dao = new MemberDAO();
		dao.InsertMember(dto);
	}
	
	public void updateMember(MemberDTO dto) {
//		MemberDAO dao = new MemberDAO();
		dao.UpdateMember(dto);
	}
	
	public void deleteMember(MemberDTO dto) {
//		MemberDAO dao = new MemberDAO();
		dao.DeleteMember(dto);
	}

	@Override
	public MemberDTO getMemberOneName(String name) {
		return dao.getMemberOneName(name);
	}

	@Override
	public void searchMemberOne(MemberDTO dto) {
		dao.SearchMemberOne(dto);
	}

	@Override
	public void searchMemberList(MemberDTO dto) {
		dao.SearchMemberList(dto);
	}
}
