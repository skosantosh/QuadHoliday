package com.quad.quadysterproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class LocationEntity {
	private int locationId;
	private String location;
	
	public LocationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "loc_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	

}
