package ioctest;

public class TVUser2 {
	
	public static void main(String[] args) {
		TV tv = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
	
}
