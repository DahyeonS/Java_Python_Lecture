package javaapipkg;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateEx {
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sf.format(date);
		System.out.println(dateStr);
		
		Calendar cal = Calendar.getInstance();
		Date d = new Date(cal.getTimeInMillis());
		System.out.println(sf.format(d));
	}
	
}
