package streampkg;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayToStream {

	public static void main(String[] args) {
		String[] arr = {"a", "b", "c", "d", "e"};
		
		Stream<String> stream1 =  Arrays.stream(arr);
	}

}
