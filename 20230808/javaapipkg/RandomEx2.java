package javaapipkg;

import java.util.Random;

public class RandomEx2 {

	public static void main(String[] args) {
		Random r = new Random();
		
		/*
//		0 ~ 6 사이
		for (int i=0; i<3; i++) {
			System.out.println(r.nextInt(6));
		}
		*/
		
//		1 ~ 7 사이
		for (int i=0; i<3; i++) {
			System.out.println(r.nextInt(6) + 1);
		}
		
//		boolean
		for (int i=0; i<5; i++) {
			System.out.println(r.nextBoolean());
		}
		
//		정규분포
		for (int i=0; i<5; i++) {
			System.out.println(r.nextGaussian());
		}
	}

}
