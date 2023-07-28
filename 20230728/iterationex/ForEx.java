package iterationex;

public class ForEx {

	public static void main(String[] args) {
//		1을 5번 반복
		for (int i=0; i<5; i++) {
			System.out.println(1);
		}
		
		System.out.println("==============================");
		
//		1 ~ 5
		int k = 0;
		for (int i=0; i<5; i++) {
			k++;
			System.out.println(k);
		}
		
		System.out.println("==============================");
		
		for (int i=1; i<6; i++) {
			System.out.println(i);
		}
		
		System.out.println("==============================");
		
//		5 ~ 1
		k = 5;
		for (int i=0; i<5; i++) {
			System.out.println(k);
			k--;
		}
		
		System.out.println("==============================");
		
		for (int i=5; i>0; i--) {
			System.out.println(i);
		}
		
		System.out.println("==============================");
		
//		1 ~ 10까지 짝수만 출력
		k = 1;
		for (int i=0; i<10; i++) {
			k++;
			if (k % 2 == 0) {
				System.out.println(k + " ");
			}
		}
		System.out.println("==============================");
		
		for (int i=1; i<11; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}

}
