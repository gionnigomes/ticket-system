package br.com.ticket.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Util {
	
	public boolean checkWeekend(LocalDate date) {
		DayOfWeek dayWeek = date.getDayOfWeek();
	    return dayWeek == DayOfWeek.SATURDAY || dayWeek == DayOfWeek.SUNDAY;	
	}
	
	

}
