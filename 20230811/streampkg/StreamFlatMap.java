package streampkg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamFlatMap {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("111 222", "333 444", "555 666");
		list1.stream()
		.flatMap(data -> Arrays.stream(data.split(" ")))
		.forEach(word -> System.out.print(word + " "));
		System.out.println();
		
		List<String> list2 = Arrays.asList("1.1 2.2 3.3", "4.4 5.5 6.6");
		DoubleStream ds = list2.stream()
				.flatMapToDouble(data -> {
					String[] arr = data.split(" ");
					double[] dArr = new double[arr.length];
					for (int i=0; i<dArr.length; i++) {
						dArr[i] = Double.parseDouble(arr[i].trim());
					}
					return Arrays.stream(dArr);
				});
		ds.forEach(d -> System.out.print(d + " "));
		System.out.println();
		
		List<String> list3 = Arrays.asList("1 2 3", "4 5 6");
		IntStream is = list3.stream()
				.flatMapToInt(data -> {
					String[] arr = data.split(" ");
					int[] iArr = new int[arr.length];
					for (int i=0; i<iArr.length; i++) {
						iArr[i] = Integer.parseInt(arr[i].trim());
					}
					return Arrays.stream(iArr);
				});
		is.forEach(i -> System.out.print(i + " "));
		System.out.println();
	}

}
