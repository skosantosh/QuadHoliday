package com.quad.quadysterproject.dto;

import java.sql.Timestamp;
import java.sql.Date;

public class HolidayDTO {

	private String holidayid;
	private String org;
	private String loc;
	private Date holiday;
	private String holidayType;
	private String holydayDesc;
	private String ctrByUser;
	private String updByUser;
	private Timestamp crtByTs;
	private Timestamp updByTs;

	public String getHolidayid() {
		return holidayid;
	}

	public void setHolidayid(String holidayid) {
		this.holidayid = holidayid;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Date getHoliday() {
		return holiday;
	}

	public void setHoliday(Date holiday) {
		this.holiday = holiday;
	}

	public String getHolidayType() {
		return holidayType;
	}

	public void setHolidayType(String holidayType) {
		this.holidayType = holidayType;
	}

	public String getHolydayDesc() {
		return holydayDesc;
	}

	public void setHolydayDesc(String holydayDesc) {
		this.holydayDesc = holydayDesc;
	}

	public String getCtrByUser() {
		return ctrByUser;
	}

	public void setCtrByUser(String ctrByUser) {
		this.ctrByUser = ctrByUser;
	}

	public String getUpdByUser() {
		return updByUser;
	}

	public void setUpdByUser(String updByUser) {
		this.updByUser = updByUser;
	}

	public Timestamp getCrtByTs() {
		return crtByTs;
	}

	public void setCrtByTs(Timestamp crtByTs) {
		this.crtByTs = crtByTs;
	}

	public Timestamp getUpdByTs() {
		return updByTs;
	}

	public void setUpdByTs(Timestamp updByTs) {
		this.updByTs = updByTs;
	}

}
