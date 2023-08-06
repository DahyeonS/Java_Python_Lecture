package animalpkg.catpkg;

import animalpkg.dogpkg.PublicProtectedDog;

public class ProtectedDogUseCat extends PublicProtectedDog {
	String friendDogName;
	
	public ProtectedDogUseCat() {
		friendDogName = protectedDogName;
		System.out.println("Protected Cat 및 Dog 1마리 생성");
		System.out.println("Friend Dog Name: " + friendDogName);
	}
}
