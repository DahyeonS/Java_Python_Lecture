package ioctest;

import org.springframework.stereotype.Component;

@Component("lg")
public class LgTV implements TV {
	public void powerOn() {
		System.out.println("LG = Power on");
	}
	
	public void powerOff() {
		System.out.println("LG = Power off");
	}
	
	public void volumeUp() {
		System.out.println("LG = Volume Up");
	}
	
	public void volumeDown() {
		System.out.println("LG = Volume Down");
	}
}
