package com.application.EasyDoctor.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeUtils {

	public static Date formatDateTimeForQuery(String value, boolean isStartOfDay) {
		Date dateObj = null;
		LocalDate localDate = LocalDate.parse(value);
		if (value != null) {
			if (isStartOfDay) {
				dateObj = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			} else {
				dateObj = Date
						.from(localDate.plusDays(1).atStartOfDay(ZoneId.systemDefault()).minusNanos(1).toInstant());
			}
		}
		return dateObj;
	}

}
