package com.quad.quadysterproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quad.quadysterproject.entity.HolidayTypeEntity;

@Repository
public interface HolidayTypeRepository extends JpaRepository<HolidayTypeEntity, Integer> {

}
