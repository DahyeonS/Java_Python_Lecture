package memberarray;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int memberIndex(String id) {
		System.out.println(id);
		MemberDTO[] m = MemberArrayData.members;
		for (int i=0; i<m.length; i++) {
			if (id.equals(m[i].getId())) return i;
		}
		return -1;
	}
	
	@Override
	public int memberNameIndex(String name) {
		System.out.println(name);
		MemberDTO[] m = MemberArrayData.members;
		for (int i=0; i<m.length; i++) {
			if (name.equals(m[i].getName())) return i;
		}
		return -1;
	}

	@Override
	public MemberDTO[] memberList() {
		return MemberArrayData.members;
	}

	@Override
	public void memberInsert(MemberDTO member) {
		System.out.println(member);
//		새 맴버만큼 길이가 늘어난 새 배열 생성
		MemberDTO[] members = MemberArrayData.members;
		int len = members.length; // 0 1
		MemberDTO[] tmp = new MemberDTO[len+1]; // 1 2
//		새 배열에 기존 맴버들을 복사
		for (int i=0; i<len; i++) {
			tmp[i] = members[i];
		}
//		마지막 인덱스에 새 맴버 삽입
		tmp[len] = member;
//		실제 주소에 적용(지역변수는 메소드가 끝나면 소멸됨)
		MemberArrayData.members = tmp;
	}

	@Override
	public void memberUpdate(int index, MemberDTO member) {
		MemberDTO[] m = MemberArrayData.members;
		m[index].setPw(member.getPw());
		m[index].setName(member.getName());
		m[index].setAge(member.getAge());
	}

	@Override
	public void memberDelete(int index) {
		MemberDTO[] m = MemberArrayData.members;
		int len = m.length;
//		새 맴버만큼 길이가 줄어든 새 배열 생성
		MemberDTO[] tmp = new MemberDTO[len-1];
//		새 배열에 기존 맴버들을 복사
		for (int i=0; i<len; i++) {
			if (i == index) continue;
			else if (i > index) tmp[i-1] = m[i];
			else tmp[i] = m[i];
		}
//		실제 주소에 적용(지역변수는 메소드가 끝나면 소멸됨)
		MemberArrayData.members = tmp;
	}
}
