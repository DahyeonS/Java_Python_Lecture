package javaapipkg;

public class MathEx {

	public static void main(String[] args) {
//		절대값
		System.out.println("Math.abs(10) = " + Math.abs(10)); // 10
		System.out.println("Math.abs(-10) = " + Math.abs(-10)); // 10
//		올림
		System.out.println("Math.ceil(5.4) = " + Math.ceil(5.4)); // 6.0
		System.out.println("Math.ceil(-5.4) = " + Math.ceil(-5.4));
//		내림
		System.out.println("Math.floor(5.4) = " + Math.floor(5.4)); // 5.0
		System.out.println("Math.floor(-5.4) = " + Math.floor(-5.4)); // -6.0
//		최대값
		System.out.println("Math.max(5, 4) = " + Math.max(5, 4)); // 5
		System.out.println("Math.max(5.4, 5.3) = " + Math.max(5.4, 5.3)); // 5.4
//		최소값
		System.out.println("Math.min(5, 4) = " + Math.min(5, 4)); // 4
		System.out.println("Math.min(5.4, 5.3) = " + Math.min(5.4, 5.3)); // 5.3
//		0 ~ 1 사이 소수
		System.out.println("Math.random() = " + Math.random());
//		짝수는 버림
		System.out.println("Math.rint(4.5) = " + Math.rint(4.5)); // 4.0
//		홀수는 올림
		System.out.println("Math.rint(5.5) = " + Math.rint(5.5)); // 6.0
//		반올림
		System.out.println("Math.round(4.5) = " + Math.round(4.5)); // 5
		System.out.println("Math.round(5.5) = " + Math.round(5.5)); // 6
	}

}
