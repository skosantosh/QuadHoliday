package com.quad.quadysterproject.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quad.quadysterproject.entity.HolidayEntity;
@Repository
public class HolidayRepositoryHHImp implements HolidayRepositoryHH {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public String createHoliday(HolidayEntity entity) {
		getSession().save(entity);
		
		return null;
	}

}
