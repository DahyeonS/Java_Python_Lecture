package javaapipkg;

import java.util.Calendar;

public class CalendarEx {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		
		int month = today.get(Calendar.MONTH); // 1: year, 2: month
		System.out.println(month + 1 + "월");
		
		int day = today.get(Calendar.DAY_OF_WEEK); // 일 ~ 토 1, 2, 3, 4, 5, 6, 7
		System.out.println(day); // 오늘은 수요일입니다.
		String[] days = {"일", "월", "화", "수", "목", "금", "토"};
		System.out.println("오늘은 " + days[day-1] + "요일입니다.");
		switch (day) {
			case 1 : System.out.println("오늘은 일요일입니다."); break;
			case 2 : System.out.println("오늘은 월요일입니다."); break;
			case 3 : System.out.println("오늘은 화요일입니다."); break;
			case 4 : System.out.println("오늘은 수요일입니다."); break;
			case 5 : System.out.println("오늘은 목요일입니다."); break;
			case 6 : System.out.println("오늘은 금요일입니다."); break;
			case 7 : System.out.println("오늘은 토요일입니다."); break;
		}
	}

}
