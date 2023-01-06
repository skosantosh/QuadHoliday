package com.quad.quadysterproject.controller;



import java.util.List;
import java.util.UUID;
import java.text.ParseException;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quad.quadysterproject.dto.HolidayDTO;
import com.quad.quadysterproject.dto.HolidayTypeDTO;
import com.quad.quadysterproject.dto.LocationDTO;
import com.quad.quadysterproject.dto.YearDiffDTO;
import com.quad.quadysterproject.service.HolidayService;

//@RestController
@Controller
public class QDController {

	@Autowired
	HolidayService service;

	@GetMapping("/")
	public String hello() {
		return "login"; 
	}

	@GetMapping("login")
	public String login(@RequestParam String login, HttpSession httpSession) {
		httpSession.setAttribute("loginBy", service.loginBy(login));
		return "index";
	}

	@GetMapping("clocktime")
	public String addHoliday(Model model, HttpSession httpSession) {

		UUID uuid = UUID.randomUUID();
		String uuidAsString = uuid.toString();
		model.addAttribute("sendID", uuidAsString);
		String userName = (String) httpSession.getAttribute("loginBy");
		
		List<LocationDTO> locations = service.getLocation();
		List<HolidayTypeDTO> holidaysType = service.getHolidayType();		
		
		model.addAttribute("locations", locations);
		model.addAttribute("holidaysType", holidaysType);
		model.addAttribute("userName", userName);

		return ("add-holiday");
	}

	@PostMapping("saveUpdate")
	public String saveUpdate(@ModelAttribute HolidayDTO dto, Model model) {
		String message = service.createHoliday(dto);
		model.addAttribute("message", message);
		return "redirect:/clocktime";
	}

	@GetMapping("location")
	public String location(Model model) {

		return ("location");
	}

	@GetMapping("holiday")
	public String holiday(Model model) {
		return ("holiday-type");
	}

	@PostMapping("savelocation")
	public String saveLocation(@ModelAttribute LocationDTO locationDTO, Model model) {
		String message = (service.createLocation(locationDTO));
		model.addAttribute("message", message);
		return "location";

	}

	@PostMapping("saveHoliday")
	public String saveHoliday(@ModelAttribute HolidayTypeDTO holidayTypeDTO, Model model) {
		String message = service.createHolidayType(holidayTypeDTO);
		model.addAttribute("message", message);
		return "holiday-type";

	}

	@GetMapping("list-holiday")
	public String listHoliday(Model model) throws NotFoundException {
		try {
			List<HolidayDTO> holidayDTOs = service.getAllList();
			model.addAttribute("getAllHolidayList", holidayDTOs);		

			List<Integer> holidayDTOsDates = service.getAllDateDic();
			model.addAttribute("holidayDTOsDates", holidayDTOsDates);
			
		} catch (Exception e) {			
			model.addAttribute("notFound","Records not found");
		}
		return "list-holiday";
		
	}



	@GetMapping("yearsonly")
	public String yearsOnly(@RequestParam String year, Model model) throws ParseException  {			
		
		List<Integer> holidayDTOsDates = service.getAllDateDic();
		model.addAttribute("holidayDTOsDates", holidayDTOsDates);
		
		if(year.equals("0")) {
			List<HolidayDTO> holidayDTOs = service.getAllList();
			model.addAttribute("getAllHolidayList", holidayDTOs);	
			return "list-holiday";
		}else {
			List<HolidayDTO> holidayDTOs = service.getYearlyData(year);
			model.addAttribute("getAllHolidayList", holidayDTOs);
			model.addAttribute("selectedYear",year);

			return "list-holiday-by-year";
		}
		

	}

	@GetMapping("update-Delete")
	public String deleteData(@RequestParam String holidayid, Model model) {
		String message = service.deleteRow(holidayid);
		model.addAttribute(message);
		return "redirect:/list-holiday";

	}
	
	@GetMapping("del")
	public String delData(@RequestParam String id, Model model, HttpSession httpSession) {
		HolidayDTO holidayDTO = service.findDataById(id);
		String userName = (String) httpSession.getAttribute("loginBy");


		model.addAttribute("holidayData", holidayDTO);
		model.addAttribute("userName", userName);

		return "del-holiday";

	}

	@GetMapping("edit")
	public String editData(@RequestParam String id, Model model, HttpSession httpSession) {
		HolidayDTO holidayDTO = service.findDataById(id);
		String userName = (String) httpSession.getAttribute("loginBy");

		List<LocationDTO> locations = service.getLocation();
		List<HolidayTypeDTO> holidaysType = service.getHolidayType();

		model.addAttribute("locations", locations);
		model.addAttribute("holidaysType", holidaysType);

		model.addAttribute("holidayData", holidayDTO);
		model.addAttribute("userName", userName);

		return "edit-holiday";

	}

	@PostMapping("update-Update")
	public String updateUpdate(@ModelAttribute HolidayDTO dto, Model model) {
		String message = service.updateHoliday(dto);
		model.addAttribute("message", message);
		return "redirect:/list-holiday";
	}
	
	@GetMapping("editYear")
	public String editYear(Model model,HttpSession httpSession) {
		YearDiffDTO diffYear = service.yearDiffDTO(1);
		model.addAttribute("diffYear",diffYear);
		String userName = (String) httpSession.getAttribute("loginBy");
		model.addAttribute("userName",userName);
		
		return "past-future-year";
	}
	
	@PostMapping("save-past-future")
	public String savePostFuture(@ModelAttribute YearDiffDTO yearDiffDTO) {
		service.saveDiffYear(yearDiffDTO);
		return "redirect:/list-holiday";
	}

}
