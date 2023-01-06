package com.quad.quadysterproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HolidayTypeEntity {
	
	private int holId;
	private String holidayName;

	public HolidayTypeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="hol_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getHolId() {
		return holId;
	}

	public void setHolId(int holId) {
		this.holId = holId;
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

}
