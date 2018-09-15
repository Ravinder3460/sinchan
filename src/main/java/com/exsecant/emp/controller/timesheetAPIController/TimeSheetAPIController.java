package com.exsecant.emp.controller.timesheetAPIController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exsecant.emp.dto.timeSheetDTO.TimeSheetDTO;
import com.exsecant.emp.service.timeSheetAPIService.TimeSheetAPIService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TimeSheetAPIController {

	@Autowired
	private TimeSheetAPIService timeSheetAPIService;

	@PostMapping("/timeSheet")
	public TimeSheetDTO createTimeSheet(@RequestBody TimeSheetDTO timeSheetDTO) {
		return timeSheetAPIService.createTimeSheet(timeSheetDTO);
	}

	@PutMapping("/timeSheet")
	public TimeSheetDTO updateTimeSheet(@RequestBody TimeSheetDTO timeSheetDTO) {
		return timeSheetAPIService.updateTimeSheet(timeSheetDTO);
	}

	@GetMapping("/timeSheet/{timeSheet-Id}")
	public TimeSheetDTO getTimeSheetRecord(@PathVariable("timeSheet-Id") long timeSheetId) {
		return timeSheetAPIService.getTimeSheetRecord(timeSheetId);
	}

	@GetMapping("/timeSheet")
	public List<TimeSheetDTO> getTimeSheetRecords() {
		return timeSheetAPIService.getTimeSheetRecords();
	}

	@DeleteMapping("/timeSheet/{deletedTimeSheetId}")
	public TimeSheetDTO deleteTimeSheet(@PathVariable("deletedTimeSheetId") long deletedTimeSheetId) {
		return timeSheetAPIService.deleteTimeSheet(deletedTimeSheetId);
	}

}
