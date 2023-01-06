package com.quad.quadysterproject.dto;

public class YearDiffDTO {
	private int Id;
	private int pastYear;
	private int futureYear;

	public YearDiffDTO() {
		super();

	}

	
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
