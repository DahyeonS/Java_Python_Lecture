package ioctest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser4 {
	
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("appContext.xml");
		TV tv = (TV)factory.getBean("tv");
		TV tv1 = (TV)factory.getBean("tv");
		tv.volumeUp();
		tv1.volumeDown();
		
		TV lg = (TV)factory.getBean("lg");
		lg.volumeDown();
		lg.volumeUp();
	}
	
}
