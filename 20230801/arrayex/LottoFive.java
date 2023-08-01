package arrayex;

import java.util.Arrays;

public class LottoFive {

	public static void main(String[] args) {
		int[][] lottoFive = new int[5][6];
		for (int i=0; i<lottoFive.length; i++) {
			for (int j=0; j<lottoFive[i].length; j++) {
				lottoFive[i][j] = (int)(Math.random() * 45) + 1;
			}
		}
		
		for (int i=0; i<lottoFive.length; i++) {
			for (int j=0; j<lottoFive[i].length-1; j++) {
				boolean changed = false;
				for (int k=0; k<lottoFive[i].length-1-j; k++) {
					if (lottoFive[i][k] > lottoFive[i][k+1]) {
						changed = true;
						int temp = lottoFive[i][k];
						lottoFive[i][k] = lottoFive[i][k+1];
						lottoFive[i][k+1] = temp;
					}
				}
				if (!changed) break;
			}
		}
		
		System.out.println(Arrays.toString(lottoFive[0]));
		System.out.println(Arrays.toString(lottoFive[1]));
		System.out.println(Arrays.toString(lottoFive[2]));
		System.out.println(Arrays.toString(lottoFive[3]));
		System.out.println(Arrays.toString(lottoFive[4]));
	}

}
