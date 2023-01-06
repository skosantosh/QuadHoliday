package com.quad.quadysterproject.UserClass;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;



@Component
public class StartDate {
	
	private String first;
	private SimpleDateFormat firstDate = null;
	private java.util.Date stYear;	

	public Date getStartDateOFYear(String year) {
		first = year + "-01-01";
		firstDate = new SimpleDateFormat("yyyy-MM-dd");
		try {
			stYear = firstDate.parse(first);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		java.sql.Date sqlDateFirst = new java.sql.Date(stYear.getTime());
		return sqlDateFirst;
	}

}
