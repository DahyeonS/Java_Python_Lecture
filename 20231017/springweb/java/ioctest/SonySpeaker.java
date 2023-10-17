package ioctest;

public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("SonySpeaker() 생성");
	}
	
	public void volumeUp() {
		System.out.println("Sony Speaker Volume Up");
	}
	
	public void volumeDown() {
		System.out.println("Sony Speaker Volume Down");
	}
}
