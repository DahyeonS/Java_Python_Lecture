package animalpkg.dogpkg;

public class PublicProtectedDog {
	protected String protectedDogName;
	int defalutAge;
	
	public PublicProtectedDog() {
		System.out.println("Public Protected Dog 1마리 생성");
		this.protectedDogName = "댕댕이";
		this.defalutAge = 3;
	}
}
