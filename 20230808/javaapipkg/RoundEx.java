package javaapipkg;

public class RoundEx {

	public static void main(String[] args) {
//		원주율을 소수점 3자리로 반올림
		double v1 = Math.PI * 1000;
		double v2 = Math.round(v1);
		double v3 = v2 / 1000;
		System.out.println(v3);
	}

}
