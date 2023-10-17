package loctest;

public class SamsungTV implements TV {
	public void powerOn() {
		System.out.println("SS = Power on");
	}
	
	public void powerOff() {
		System.out.println("SS = Power off");
	}
	
	public void volumeUp() {
		System.out.println("SS = Volume Up");
	}
	
	public void volumeDown() {
		System.out.println("SS = Volume Down");
	}
}
