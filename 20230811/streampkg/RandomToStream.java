package streampkg;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RandomToStream {

	public static void main(String[] args) {
//		int random 3개의 stream
		IntStream is = new Random().ints(3);
		is.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		is = new Random().ints(6, 1, 46); // 0 ~ 45까지의 정수
		is.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		LongStream ls = new Random().longs(6, 1, 46); // 0 ~ 45까지의 정수
		ls.forEach(s -> System.out.print(s + " "));
		System.out.println();
	}
	
}
