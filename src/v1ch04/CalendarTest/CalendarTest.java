package v1ch04.CalendarTest;

import java.time.*;

/**
 * @version 1.5 2015-05-08
 * @author Cay Horstmann
 */

public class CalendarTest {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		// System.out.println(date); 2018-03-08
		int month = date.getMonthValue();
		int today = date.getDayOfMonth();

		date = date.minusDays(today - 1); // 设置为月初
		DayOfWeek weekday = date.getDayOfWeek();//星期几，一周中第几天
		//The values are numbered following the ISO-8601 standard, from 1 (Monday) to 7 (Sunday). 
		int value = weekday.getValue(); // 1 = Monday, ... 7 = Sunday

		// System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		System.out.println("星期一 星期二 星期三 星期四 星期五 星期六 星期天");
		//表格里月初1号前面的空白部分
		for (int i = 1; i < value; i++) {
			System.out.print("      ");
		}
		while (date.getMonthValue() == month) {
			System.out.printf("%5d", date.getDayOfMonth());
			if (date.getDayOfMonth() == today) {
				System.out.print("*");
			} else {
				System.out.print(" ");
			}
			//日期+1
			date = date.plusDays(1);
			//日期+1后如果是星期一，原日期是星期天，换行
			if (date.getDayOfWeek().getValue() == 1) {
				System.out.println();
			}
		}
		if (date.getDayOfWeek().getValue() != 1) {
			System.out.println();
		}
	}
}