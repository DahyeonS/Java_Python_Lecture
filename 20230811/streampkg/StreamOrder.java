package streampkg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamOrder {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("hong", "kim", "park", "lee", "you");
		list.stream()
			.sorted()
			.forEach(System.out::println); // 순서대로 정렬
		
		System.out.println("=====================");
		
		list.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(System.out::println); // 역순 정렬
	}

}
