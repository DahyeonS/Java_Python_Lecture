# Spring AJAX
기존 JSP 방식과 비슷함

```java
@RestController
@RequestMapping("api")
public class MemberControllerAjax {
	@Autowired
	@Qualifier("memberServiceImpl")
	MemberService service;
	
	@GetMapping("memberListJson")
	public Map<String, Object> memberList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MemberDTO> list = service.getMemberList();
		
		if(list.size() != 0) map.put("rs", list);
		else map.put("rs", 0);
		
		return map;
	}
}
```