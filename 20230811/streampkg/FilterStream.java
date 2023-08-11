package streampkg;

import java.util.Arrays;
import java.util.List;

public class FilterStream {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("hong", "kim", "hong", "lee", "you");
//		distinct
		list.stream()
		.distinct()
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
//		filter "ho"
		list.stream()
		.filter(s -> s.startsWith("ho"))
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
//		distinct -> filter "ho"
		list.stream()
		.distinct()
		.filter(s -> s.startsWith("ho"))
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
//		distinct -> filter "le"
		list.stream()
		.distinct()
		.filter(s -> s.startsWith("le"))
		.forEach(s -> System.out.print(s + " "));
	}

}
