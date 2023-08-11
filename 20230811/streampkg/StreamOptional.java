package streampkg;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class StreamOptional {

	public static void main(String[] args) {
		int[] arr = new int[100];
		for (int i=0; i<arr.length; i++) {
			arr[i] = i + 1;
		}
		
//		count
		long count = Arrays.stream(arr).count();
		System.out.println(count);
		
//		sum
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum);
		
//		first
		OptionalInt first = Arrays.stream(arr).findFirst();
		System.out.println(first.getAsInt());
		
//		max
		OptionalInt max = Arrays.stream(arr).max();
		System.out.println(max.getAsInt());
		
//		min
		OptionalInt min = Arrays.stream(arr).min();
		System.out.println(min.getAsInt());
		
//		avg
		OptionalDouble avg = Arrays.stream(arr).average();
		System.out.println(avg.getAsDouble());
	}

}
