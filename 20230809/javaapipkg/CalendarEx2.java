package javaapipkg;

import java.util.Date;

public class CalendarEx2 {

	public static void main(String[] args) {
		int sYear = 2020;
		int sMonth = 6;
		int sDay = 1;
		
		int eYear = 2020;
		int eMonth = 6;
		int eDay = 12;
		
		Date sd = new Date();
		sd.setYear(sYear);
		sd.setMonth(sMonth - 1);
		sd.setDate(sDay);
		
		Date ed = new Date();
		ed.setYear(eYear);
		ed.setMonth(eMonth - 1);
		ed.setDate(eDay);
		
		long temp = (ed.getTime() - sd.getTime()) / (1000L * 60L * 60L * 24L);
		System.out.println(temp);
	}

}
