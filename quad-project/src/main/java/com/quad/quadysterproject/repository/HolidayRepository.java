package com.quad.quadysterproject.repository;

import java.sql.Date;


import java.util.HashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quad.quadysterproject.entity.HolidayEntity;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayEntity, String> {

	/*
	 * @Query ("Select distinct EXTRACT(YEAR from h.holiday) from HolidayEntity h ")
	 * List<Integer>findAllDate();
	 */
	
	@Query("Select EXTRACT(YEAR from h.holiday) from HolidayEntity h where h.holiday between :pYearBack and :pYearFuture ")
	HashSet<Integer> findAllDateHash(@Param("pYearBack") Date pYearBack, @Param("pYearFuture") Date pYearFuture);

	@Query("from HolidayEntity h where h.holiday between :pStartYear and :pEndYear ORDER By h.holiday DESC")
	List<HolidayEntity> getAllDataByYear(@Param("pStartYear") Date pStartYear,@Param("pEndYear") Date pEndYear);

}

/*
 * @Query("from HolidayEntity h where h.holiday like %:Pyear%")
 * 
 * List<HolidayEntity> getYearlyData(@Param("Pyear") String year);
 */
