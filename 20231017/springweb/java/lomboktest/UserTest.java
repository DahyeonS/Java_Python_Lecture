package lomboktest;


public class UserTest {

	public static void main(String[] args) {
		UserDTO user = new UserDTO();
		user.setName("Hong");
		user.setAge(11);
		user.setEmail("hong@e.com");
		
		System.out.println(user.toString());
		System.out.println(user.getAge());
		
		UserDTO2 user2 = UserDTO2.builder()
				.name("hong")
				.age(12)
				.email("hong@e.com")
				.build();
		System.out.println(user2.toString());
	}

}
