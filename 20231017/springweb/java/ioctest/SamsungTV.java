package ioctest;

public class SamsungTV implements TV {
	Speaker speaker;
	int price;
	
	public SamsungTV() {
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("SamsungTV() 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("SS = Power on");
	}
	
	public void powerOff() {
		System.out.println("SS = Power off");
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
	
	
}
