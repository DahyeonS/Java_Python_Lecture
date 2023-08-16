package memberfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MemberDAOImpl implements MemberDAO {
	final String PATH = "C:/kdigital2307/data/member.txt";
	
	public List<MemberDTO> readmembers() {
		List<MemberDTO> members = new ArrayList<MemberDTO>();
		FileReader fr = null;
		BufferedReader bfr = null;
		StringTokenizer st = null;
		
		try {
			fr = new FileReader(PATH);
			bfr = new BufferedReader(fr);
			
			List<String> memberList = new ArrayList<String>();
			String str = null;
			
			while (true) {
				str = bfr.readLine();
				if (str == null) break;
				memberList.add(str);
			}
			
			for (String s : memberList) {
				st = new StringTokenizer(s, ",");
				String id = st.nextToken();
				String ps = st.nextToken();
				String name = st.nextToken();
				int age = Integer.parseInt(st.nextToken());
				MemberDTO member = new MemberDTO(id, ps, name, age);
				members.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bfr.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return members;
	}
	
	void writeMembers(MemberDTO member) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		String msg = "";
		msg += member.getId();
		msg += "," + member.getPw();
		msg += "," + member.getName();
		msg += "," + member.getAge();
		
		try {
			fw = new FileWriter(PATH, true); // append - true
			bw = new BufferedWriter(fw);
			bw.write(msg);
			bw.newLine();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	void writeMembers(List<MemberDTO> members) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(PATH); // append - true
			bw = new BufferedWriter(fw);
			for (MemberDTO member : members) {
				String msg = "";
				msg += member.getId();
				msg += "," + member.getPw();
				msg += "," + member.getName();
				msg += "," + member.getAge();
				bw.write(msg);
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@Override
	public int memberIndex(String id) {
		System.out.println(id);
		List<MemberDTO> m = readmembers();
		for (int i=0; i<m.size(); i++) {
			if (id.equals(m.get(i).getId())) return i;
		}
		return -1;
	}
		
	@Override
	public List<MemberDTO> memberList() {
		return readmembers();
	}
	
	@Override
	public void memberInsert(MemberDTO member) {
		System.out.println(member);
		writeMembers(member);
	}

	@Override
	public void memberUpdate(int index, MemberDTO member) {
		List<MemberDTO> m = readmembers();
		m.get(index).setPw(member.getPw());
		m.get(index).setName(member.getName());
		m.get(index).setAge(member.getAge());
		
		writeMembers(m);
	}

	@Override
	public void memberDelete(int index) {
		List<MemberDTO> m = readmembers();
		m.remove(index);
		
		writeMembers(m);
	}
}
