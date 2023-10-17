package ioctest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg")
public class LgTV implements TV {
	@Autowired
	@Qualifier("apple")
	Speaker speaker;
	
	@Autowired
	Remocon remocon;
	
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
