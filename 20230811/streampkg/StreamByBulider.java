package streampkg;

import java.util.stream.Stream;

public class StreamByBulider {

	public static void main(String[] args) {
		Stream stream = Stream.builder()
				.add("무궁화")
				.add("삼천리")
				.add("화려강산")
				.add("대한사람")
				.build();
		stream.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream<String> stream2 = Stream.<String>builder()
				.add("무궁화")
				.add("삼천리")
				.add("화려강산")
				.add("대한사람")
				.build();
		stream2.forEach(s -> System.out.print(s + " "));
		System.out.println();
	}

}
