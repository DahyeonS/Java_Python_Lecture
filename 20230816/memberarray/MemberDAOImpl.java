package memberarraylist;

import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int memberIndex(String id) {
		System.out.println(id);
		List<MemberDTO> m = MemberArrayListData.members;
		for (int i=0; i<m.size(); i++) {
			if (id.equals(m.get(i).getId())) return i;
		}
		return -1;
	}
	
	@Override
	public int memberNameIndex(String name) {
		System.out.println(name);
		List<MemberDTO> m = MemberArrayListData.members;
		for (int i=0; i<m.size(); i++) {
			if (name.equals(m.get(i).getName())) return i;
		}
		return -1;
	}

	@Override
	public MemberDTO memberNameDTO(String name) {
		System.out.println(name);
		List<MemberDTO> m = MemberArrayListData.members;
		for (MemberDTO dto : m) {
			if (name.equals(dto.getName())) return dto;
		}
		return null;
	}
	
	@Override
	public List<MemberDTO> memberList() {
		return MemberArrayListData.members;
	}
	
	@Override
	public List<MemberDTO> memberList(String name) {
		List<MemberDTO> m = MemberArrayListData.members;
		List<MemberDTO> rs = new ArrayList<MemberDTO>();
		for (MemberDTO dto : m) {
			if (name.equals(dto.getName())) rs.add(dto);
		}
		return rs;
	}

	@Override
	public void memberInsert(MemberDTO member) {
		System.out.println(member);
		List<MemberDTO> members = MemberArrayListData.members;
		members.add(member);
	}

	@Override
	public void memberUpdate(int index, MemberDTO member) {
		List<MemberDTO> m = MemberArrayListData.members;
		m.get(index).setPw(member.getPw());
		m.get(index).setName(member.getName());
		m.get(index).setAge(member.getAge());
	}

	@Override
	public void memberDelete(int index) {
		List<MemberDTO> m = MemberArrayListData.members;
		m.remove(index);
	}
}
