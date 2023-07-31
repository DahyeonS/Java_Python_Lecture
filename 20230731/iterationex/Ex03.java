package iterationex;

public class Ex03 {

	public static void main(String[] args) {
//		1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10) 의 결과값을 구하시오.
		int sum = 0;
		int totalSum = 0;
		for (int i=0; i<11; i++) {
			sum = sum + i;
			totalSum = totalSum + sum;
		}
		System.out.println(totalSum);
	}

}
