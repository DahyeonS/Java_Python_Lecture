# Spring을 이용한 회원관리
[회원관리](https://github.com/DahyeonS/Java_Python_Lecture/tree/main/20230814) 스프링 버전

- 컨트롤러단
```java
@Controller
@RequestMapping("member")
public class MemberController {
	String view;
	
	@Autowired
	@Qualifier("memberServiceImpl")
	MemberService service;
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		view = "member/join";
		return view;
	}
	
	@GetMapping(value = "login")
	public String login() {
		view = "member/login";
		return view;
	}
	
	@PostMapping("login")
	public String loginAction(MemberDTO dto, HttpSession session) {
		view = "member/login";
		String id = dto.getId();
		String pw = dto.getPw();
		
		dto = service.getMember(dto);
		
		if (dto != null) {
			if (dto.getPw().equals(pw)) {
				session.setAttribute("id", id);
				session.setAttribute("name", dto.getName());
				session.setAttribute("role", dto.getRole());
				
				view = "redirect:../";
			}
		}
		return view;
	}
```

- 서비스단
```java
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	@Qualifier("memberDAOImpl")
	MemberDAO dao;
	
	@Override
	public int insert(MemberDTO dto) {
		return dao.insert(dto);
	}
}
```

- DAO단
```java
@Repository
public class MemberDAOImpl implements MemberDAO {
	Connection conn;
	
	private Connection getConnection() {
		Connection conn = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			
			String dbname = "javaweb";	
			String url = "jdbc:mysql://localhost:3306/"+dbname+"?ServerTimezone=UTC";
			String user = "root";
			String password = "rpass";
			
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

```