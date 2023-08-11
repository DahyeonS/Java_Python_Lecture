package streampkg;

import java.util.stream.Stream;

public class StreamByGenerator {

	public static void main(String[] args) {
		Stream<String> stream = Stream.generate(() -> "애국가").limit(10);
		stream.forEach(s -> System.out.print(s + " "));
		System.out.println();
	}

}
