package polymorphismpkg;

import java.util.ArrayList;

public class AnimalPolyArrayListMain {

	public static void main(String[] args) {
		Animal chicken = new Chicken();
		Animal eagle = new Eagle();
		Animal pig = new Pig();
		Animal tiger = new Tiger();
		
		ArrayList arrayList = new ArrayList();
		arrayList.add(chicken);
		arrayList.add(eagle);
		arrayList.add(pig);
		arrayList.add(tiger);
		
		AnimalPrint ap = new AnimalPrint(arrayList);
	}

}
