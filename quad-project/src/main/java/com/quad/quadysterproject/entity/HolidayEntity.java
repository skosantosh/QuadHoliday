package com.quad.quadysterproject.entity;

import java.sql.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ETT_HOLIDAY")
public class HolidayEntity {

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

	@Id
	@Column(name = "HOLIDAY_ID", length = 50)
	public String getHolidayid() {
		return holidayid;
	}

	public void setHolidayid(String holidayid) {
		this.holidayid = holidayid;
	}

	@Column(name = "ORG_CD", nullable = false, length = 50)
	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	@Column(name = "LOC_CD", length = 50, nullable = false)

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Column(name = "HOLIDAY", nullable = false)
	public Date getHoliday() {
		return holiday;
	}

	public void setHoliday(Date holiday) {
		this.holiday = holiday;
	}

	@Column(name = "HOLIDAY_TYPE", nullable = false, length = 50)
	public String getHolidayType() {
		return holidayType;
	}

	public void setHolidayType(String holidayType) {
		this.holidayType = holidayType;
	}

	@Column(name = "HOLIDAY_DESC", nullable = false, length = 2048)
	public String getHolydayDesc() {
		return holydayDesc;
	}

	public void setHolydayDesc(String holydayDesc) {
		this.holydayDesc = holydayDesc;
	}

	@Column(name = "CRT_BY_USER", nullable = false, length = 50)
	public String getCtrByUser() {
		return ctrByUser;
	}

	public void setCtrByUser(String ctrByUser) {
		this.ctrByUser = ctrByUser;
	}

	@Column(name = "UPD_BY_USER", length = 50, nullable = false)
	public String getUpdByUser() {
		return updByUser;
	}

	public void setUpdByUser(String updByUser) {
		this.updByUser = updByUser;
	}

	@Column(name = "CRT_BY_TS", nullable = false)
	public Timestamp getCrtByTs() {
		return crtByTs;
	}

	public void setCrtByTs(Timestamp crtByTs) {
		this.crtByTs = crtByTs;
	}

	@Column(name = "UPD_BY_TS", nullable = false)
	public Timestamp getUpdByTs() {
		return updByTs;
	}

	public void setUpdByTs(Timestamp updByTs) {
		this.updByTs = updByTs;
	}

}
