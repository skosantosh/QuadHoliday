package com.quad.quadysterproject.service;

import java.text.ParseException;

import java.util.List;

import com.quad.quadysterproject.dto.HolidayDTO;
import com.quad.quadysterproject.dto.HolidayTypeDTO;
import com.quad.quadysterproject.dto.LocationDTO;
import com.quad.quadysterproject.dto.YearDiffDTO;

public interface HolidayService {

	List<HolidayDTO> getAllList();

	String createHoliday(HolidayDTO holidayDto);

	String createHolidayType(HolidayTypeDTO holidayTypeDTO);

	String createLocation(LocationDTO locationDTO);

	List<LocationDTO> getLocation();

	List<HolidayTypeDTO> getHolidayType();

	String loginBy(String userName);

	String deleteRow(String id);

	HolidayDTO findDataById(String id);

	String updateHoliday(HolidayDTO holidayDto);

	List<Integer> getAllDateDic();

	List<HolidayDTO> getYearlyData(String year) throws ParseException;

	YearDiffDTO yearDiffDTO(int id);
	
	void saveDiffYear(YearDiffDTO yearDiffDTO);

}
