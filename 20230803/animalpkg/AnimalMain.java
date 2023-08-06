package animalpkg;

import animalpkg.catpkg.ProtectedDogUseCat;
import animalpkg.dogpkg.PublicDog;

public class AnimalMain {

	public static void main(String[] args) {
		PublicDog publicDog = new PublicDog();
//		DefaultDog = defaultDog = new DefaultDog(); // Error!!
		
		ProtectedDogUseCat protectedDogUseCat = new ProtectedDogUseCat();
	}

}
