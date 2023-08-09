package javaapipkg;

import java.util.Calendar;

public class CalendarEx3 {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		
		System.out.println("올해 년도: " + today.get(Calendar.YEAR));
		System.out.println("이번 달: " + today.get(Calendar.MONTH));
		System.out.println("년도 기준 몇째주: " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("월 기준 몇째주: " + today.get(Calendar.WEEK_OF_MONTH));
		System.out.println("일자: " + today.get(Calendar.DATE));
		System.out.println("일자: " + today.get(Calendar.DAY_OF_MONTH));
		System.out.println("년도 기준 날짜: " + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("요일(일 ~ 토): " + today.get(Calendar.DAY_OF_WEEK)); // 일(0), 월(1), 화(2), 수(3), 목(4), 금(5), 토(6)
		System.out.println("월 기준 몇번째 요일: " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		
		System.out.println("오전(0) 오후(1): " + today.get(Calendar.AM_PM));
		System.out.println("시간(0 ~ 11): " + today.get(Calendar.HOUR));
		System.out.println("시간(0 ~ 23): " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0 ~ 59): " + today.get(Calendar.MINUTE));
		System.out.println("초(0 ~ 59): " + today.get(Calendar.SECOND));
		System.out.println("밀리초(0 ~ 999): " + today.get(Calendar.MILLISECOND));
		System.out.println("Timezone(12 ~ 12): " + today.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000));
		System.out.println("이번 달의 마지막 일자: " + today.getActualMaximum(Calendar.DATE));
		
		Calendar cal = Calendar.getInstance();
		cal.set(2020, (6 - 1), 12);
		System.out.println("날짜: " + cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH) + 1) + "월 " + cal.get(Calendar.DATE) + "일");
	}
	
}
