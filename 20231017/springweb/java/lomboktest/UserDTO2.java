package lomboktest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO2 {
	private String name;
	private int age;
	private String email;
}
