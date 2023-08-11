package streampkg;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayToStream {

	public static void main(String[] args) {
		String[] arr = {"a", "b", "c", "d", "e"};
		
		Stream<String> stream1 =  Arrays.stream(arr);
		stream1.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream<String> stream2 =  Arrays.stream(arr, 2, 5); // 2 ~ 5 인덱스까지 호출
		stream2.forEach(s -> System.out.print(s + " "));
		System.out.println();
	}

}
