package collectionpkg;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoUseSet {

	public static void main(String[] args) {
		Random n = new Random();
		Set lotto = new HashSet();
		while (true) {
			int r = n.nextInt(45) + 1; // 1 ~ 45
			lotto.add(r);
			
			if (lotto.size() == 6) break;
		}
		System.out.println(lotto);
		
		Set lotto2 = new TreeSet();
		while (true) {
			int r = n.nextInt(45) + 1;
			lotto2.add(r);
			if (lotto2.size() == 6) break;
		}
		System.out.println(lotto2);
	}

}
