package com.cozarb.service.util;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {
	public static Date getBeforeDateofDays(int days) {
		Date d = null;
		LocalDate lDate = null;

		lDate = LocalDate.now();
		lDate = lDate.atStartOfDay().minusDays(days).toLocalDate();
		Calendar c = Calendar.getInstance(Locale.getDefault());
		c.set(Calendar.YEAR, lDate.getYear());
		c.set(Calendar.MONTH, lDate.getMonthValue()-1);
		c.set(Calendar.DAY_OF_MONTH, lDate.getDayOfMonth());
		d = c.getTime();

		return d;
	}

}
