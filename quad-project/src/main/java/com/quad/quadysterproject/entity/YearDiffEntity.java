package com.quad.quadysterproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class YearDiffEntity {
	private int Id ;
	private int pastYear;
	private int futureYear;

	public YearDiffEntity() {
		super();
		
	}
	@Id
	@Column(name = "id")
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getPastYear() {
		return pastYear;
	}

	public void setPastYear(int pastYear) {
		this.pastYear = pastYear;
	}

	public int getFutureYear() {
		return futureYear;
	}

	public void setFutureYear(int futureYear) {
		this.futureYear = futureYear;
	}

}
