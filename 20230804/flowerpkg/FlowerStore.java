package flowerpkg;

public class FlowerStore {
	Lilac lilac;
	Sunflower sunflower;
	Rose rose;
	
	public FlowerStore(Rose rose) {
		System.out.println("장미꽃가게 오픈");
		this.rose = rose;
	}
	
	public FlowerStore(Lilac lilac, Sunflower sunflower) {
		System.out.println("라일락해바라기꽃가게 오픈");
		this.lilac = lilac;
		this.sunflower = sunflower;
	}
	
	public FlowerStore(Lilac lilac, Sunflower sunflower, Rose rose) {
		this.lilac = lilac;
		this.sunflower = sunflower;
		this.rose = rose;
	}
}
