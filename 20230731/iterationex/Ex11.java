package iterationex;

public class Ex11 {

	public static void main(String[] args) {
//		2x+4y=10 방정식의 해 x y를 구하시오. 범위 0<=x<=10, 0<=y<=10
		for (int x=0; x<11; x++) {
			for (int y=0; y<11; y++) {
				if (2*x + 4*y == 10) System.out.printf("(%s,%s)", x, y);
			}
		}
	}

}
