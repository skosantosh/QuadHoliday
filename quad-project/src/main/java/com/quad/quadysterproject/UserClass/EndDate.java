package com.quad.quadysterproject.UserClass;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;



@Component
public class EndDate {

	
	private String end;
	private SimpleDateFormat endDate = null;
	private java.util.Date endYear;

	public Date getEndDateOFYear(String year) {
		end = year + "-12-31";
		endDate = new SimpleDateFormat("yyyy-MM-dd");
		try {
			endYear = endDate.parse(end);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		java.sql.Date sqlDateFirst = new java.sql.Date(endYear.getTime());
		return sqlDateFirst;
	}

}
