package streampkg;

import java.util.Arrays;
import java.util.List;

public class StreamMap {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("111 222", "333 444", "555 666");
//		함수적 인터페이스
		list.stream()
		.mapToInt(s -> s.length())
		.forEach(len -> System.out.print(len + " ")); // 각 원소 길이 출력
		System.out.println();
		
//		메서드 참조방식 ::
		list.stream()
		.mapToInt(String::length)
		.forEach(len -> System.out.print(len + " "));
		System.out.println();
	}

}
