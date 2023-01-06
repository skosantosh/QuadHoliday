package com.quad.quadysterproject.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.HashSet;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quad.quadysterproject.UserClass.EndDate;
import com.quad.quadysterproject.UserClass.StartDate;
import com.quad.quadysterproject.dto.HolidayDTO;
import com.quad.quadysterproject.dto.HolidayTypeDTO;
import com.quad.quadysterproject.dto.LocationDTO;
import com.quad.quadysterproject.dto.YearDiffDTO;
import com.quad.quadysterproject.entity.HolidayEntity;
import com.quad.quadysterproject.entity.HolidayTypeEntity;
import com.quad.quadysterproject.entity.LocationEntity;
import com.quad.quadysterproject.entity.YearDiffEntity;
import com.quad.quadysterproject.repository.DiffYearsRepository;
import com.quad.quadysterproject.repository.HolidayRepository;
import com.quad.quadysterproject.repository.HolidayRepositoryHH;
import com.quad.quadysterproject.repository.HolidayTypeRepository;
import com.quad.quadysterproject.repository.LocationRepository;

@Service
@Transactional
public class HolidayServiceImplement implements HolidayService {

	@Autowired
	HolidayRepository holidayRepository;

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	HolidayTypeRepository holidayTypeRepository;

	@Autowired
	HolidayRepositoryHH holidayRepositoryHH;
	
	@Autowired
	DiffYearsRepository diffYearsRepository;

	@Autowired
	StartDate startDate;
	@Autowired
	EndDate endDate;

	@Override
	public List<HolidayDTO> getAllList() {
		List<HolidayDTO> holidayDTOs = new ArrayList<>();
		List<HolidayEntity> holidayEntities = holidayRepository.findAll();
		for (HolidayEntity holidayEntity : holidayEntities) {
			HolidayDTO holidayDTO = new HolidayDTO();
			BeanUtils.copyProperties(holidayEntity, holidayDTO);
			holidayDTOs.add(holidayDTO);
		}

		return holidayDTOs;
	}

	@Override
	public List<Integer> getAllDateDic() {
		int year, dateF, dateP;
		String stDateF = null, stDateP = null;
		
		YearDiffEntity yearDiffEntity = diffYearsRepository.getById(1);

		LocalDate currentDate = LocalDate.now();

		year = currentDate.getYear();
		/*
		 * dateP = year - 3;
		 * dateF = year + 3;
		 */

		dateP = year - yearDiffEntity.getPastYear();
		dateF = year + yearDiffEntity.getFutureYear();

		stDateF = String.valueOf(dateF);
		stDateP = String.valueOf(dateP);

		/*
		 * LocalDate currentDateplus = LocalDate.now(); currentDateplus =
		 * currentDateplus.plusDays(1095); java.sql.Date sqlDateF =
		 * java.sql.Date.valueOf(currentDateplus);
		 * 
		 * LocalDate currentDateminus = LocalDate.now(); currentDateminus =
		 * currentDateminus.minusDays(1095); java.sql.Date sqlDateP =
		 * java.sql.Date.valueOf(currentDateminus);
		 */

		Date sqlDateP, sqlDateF;
		sqlDateP = startDate.getStartDateOFYear(stDateP);
		sqlDateF = endDate.getEndDateOFYear(stDateF);

		List<Integer> yearSOnly = new ArrayList<Integer>();
		HashSet<Integer> yeraFromDb = holidayRepository.findAllDateHash(sqlDateP, sqlDateF);

		for (Integer holidayEntity : yeraFromDb) {
			yearSOnly.add(holidayEntity);
		}
		return yearSOnly;
	}

	@Override
	public String createHoliday(HolidayDTO holidayDto) {

		HolidayEntity holidayEntity = new HolidayEntity();
		BeanUtils.copyProperties(holidayDto, holidayEntity);
		// holidayEntity.setHolidayid(uuidAsString);
		// holidayEntity.setCtrByUser("Amit");
		// holidayEntity.setUpdByUser("Kumar");
		holidayEntity.setOrg("CBP");
		holidayEntity.setCrtByTs(new Timestamp(System.currentTimeMillis()));
		holidayEntity.setUpdByTs(new Timestamp(System.currentTimeMillis()));
		holidayRepository.save(holidayEntity);
		return "Successfully Saved";
	}

	@Override
	public String createLocation(LocationDTO locationDTO) {
		LocationEntity locationEntity = new LocationEntity();
		BeanUtils.copyProperties(locationDTO, locationEntity);
		locationRepository.save(locationEntity);
		return "Location Saved";
	}

	@Override
	public String createHolidayType(HolidayTypeDTO holidayTypeDTO) {
		HolidayTypeEntity holidayTypeEntity = new HolidayTypeEntity();
		BeanUtils.copyProperties(holidayTypeDTO, holidayTypeEntity);
		holidayTypeRepository.save(holidayTypeEntity);
		return "Holiday Type Saved";
	}

	@Override
	public List<LocationDTO> getLocation() {
		List<LocationDTO> locationDTOs = new ArrayList<LocationDTO>();
		List<LocationEntity> locationEntities = locationRepository.findAll();

		for (LocationEntity locationEntity : locationEntities) {
			LocationDTO locationDTO = new LocationDTO();
			BeanUtils.copyProperties(locationEntity, locationDTO);
			locationDTOs.add(locationDTO);
		}

		return locationDTOs;
	}

	@Override
	public List<HolidayTypeDTO> getHolidayType() {
		List<HolidayTypeDTO> holidayTypeDTOs = new ArrayList<HolidayTypeDTO>();
		List<HolidayTypeEntity> holidayTypeEntities = holidayTypeRepository.findAll();

		for (HolidayTypeEntity holidayTypeEntity : holidayTypeEntities) {
			HolidayTypeDTO holidayTypeDTO = new HolidayTypeDTO();
			BeanUtils.copyProperties(holidayTypeEntity, holidayTypeDTO);
			holidayTypeDTOs.add(holidayTypeDTO);

		}
		return holidayTypeDTOs;
	}

	@Override
	public String loginBy(String userName) {

		return userName;
	}

	@Override
	public List<HolidayDTO> getYearlyData(String year) throws ParseException {

		/*
		 * String first = year + "-01-01"; String second = year + "-12-31";
		 * 
		 * SimpleDateFormat firstDate = null; try { firstDate = new
		 * SimpleDateFormat("yyyy-MM-dd"); } catch (Exception e) {
		 * 
		 * e.printStackTrace(); } java.util.Date stYear = firstDate.parse(first);
		 * 
		 * SimpleDateFormat secondDate = null; try { secondDate = new
		 * SimpleDateFormat("yyyy-MM-dd"); } catch (Exception e) {
		 * 
		 * e.printStackTrace(); } java.util.Date endYear = secondDate.parse(second);
		 * 
		 * java.sql.Date sqlDateFirst = new java.sql.Date(stYear.getTime());
		 * java.sql.Date sqlDateSecond = new java.sql.Date(endYear.getTime());
		 */

		Date sqlDateFirst, sqlDateSecond;

		sqlDateFirst = startDate.getStartDateOFYear(year);
		sqlDateSecond = endDate.getEndDateOFYear(year);

		List<HolidayDTO> holidayDTOs = new ArrayList<>();
		List<HolidayEntity> holidayEntities = holidayRepository.getAllDataByYear(sqlDateFirst, sqlDateSecond);
		for (HolidayEntity holidayEntity : holidayEntities) {
			HolidayDTO holidayDTO = new HolidayDTO();
			BeanUtils.copyProperties(holidayEntity, holidayDTO);
			holidayDTOs.add(holidayDTO);
		}
		return holidayDTOs;
	}

	@Override
	public String deleteRow(String id) {
		holidayRepository.deleteById(id);
		return "Delete Success";
	}

	@Override
	public HolidayDTO findDataById(String id) {
		HolidayDTO holidayDTO = new HolidayDTO();
		Optional<HolidayEntity> holidayEntity = holidayRepository.findById(id);
		if (holidayEntity.isPresent()) {
			HolidayEntity entityGet = holidayEntity.get();
			BeanUtils.copyProperties(entityGet, holidayDTO);
			return holidayDTO;
		} else {
			return null;
		}

	}

	@Override
	public String updateHoliday(HolidayDTO holidayDto) {
		HolidayEntity holidayEntity = new HolidayEntity();
		BeanUtils.copyProperties(holidayDto, holidayEntity);
		/*
		 * holidayEntity.setHolidayid(holidayDto.getHolidayid());
		 * holidayEntity.setHoliday(holidayDto.getHoliday());
		 * holidayEntity.setHolidayType(holidayDto.getHolidayType());
		 * holidayEntity.setHolydayDesc(holidayDto.getHolydayDesc());
		 * holidayEntity.setLoc(holidayDto.getLoc());
		 * holidayEntity.setUpdByUser(holidayDto.getUpdByUser());
		 * holidayEntity.setCrtByTs(holidayDto.getCrtByTs());
		 */
		holidayEntity.setOrg("CBP");
		holidayEntity.setUpdByTs(new Timestamp(System.currentTimeMillis()));
		holidayRepository.save(holidayEntity);
		return "Successfully Update";
	}

	@Override
	public YearDiffDTO yearDiffDTO(int id) {
		YearDiffDTO yearDiffDTO = new YearDiffDTO();
		Optional<YearDiffEntity> yearDiffEntity = diffYearsRepository.findById(id);
		if(yearDiffEntity.isPresent()) {
			YearDiffEntity diffEntityGet = yearDiffEntity.get();
			BeanUtils.copyProperties(diffEntityGet, yearDiffDTO);
			return yearDiffDTO;
		}else {
			yearDiffDTO.setId(1);
			yearDiffDTO.setFutureYear(3);
			yearDiffDTO.setPastYear(3);
			return yearDiffDTO;
		}		
	}

	@Override
	public void saveDiffYear(YearDiffDTO yearDiffDTO) {
		YearDiffEntity yearDiffEntity = new YearDiffEntity();
		BeanUtils.copyProperties(yearDiffDTO, yearDiffEntity);
		diffYearsRepository.save(yearDiffEntity);	
	}

}
