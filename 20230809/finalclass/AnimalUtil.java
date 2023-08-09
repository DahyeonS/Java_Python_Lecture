package finalclass;

import java.util.List;

public class AnimalUtil {
	
//	동물의 이름을 출력하는 기능
	void printName(Animal animal) {
		System.out.print(animal.name + " ");
	}
	
//	동물들의 이름을 출력하는 기능
	
	void printName(Animal[] animal) {
		for (int i=0; i<animal.length; i++) {
			Animal a = (Animal)animal[i];
			System.out.print(a.name + " ");
		}
	}
	
	void printName(List animal) {
		for (int i=0; i<animal.size(); i++) {
			Animal a = (Animal)animal.get(i);
			System.out.print(a.name + " ");
		}
	}
	
//	Egg는 나이만
	void printAge(Egg egg) {
		Animal a = (Animal)egg;
		System.out.print(a.age + " ");
	}
	
//	Egg들의 나이
	void printAge(Egg[] egg) {
		for (int i=0; i<egg.length; i++) {
			Animal a = (Animal)egg[i];
			System.out.print(a.age + " ");
		}
	}
	
	void printAge(List egg) {
		for (int i=0; i<egg.size(); i++) {
			Animal a = (Animal)egg.get(i);
			System.out.print(a.age + " ");
		}
	}
}
