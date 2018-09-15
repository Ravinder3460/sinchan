package com.exsecant.emp.service.timeSheetAPIService;

import java.util.List;

import com.exsecant.emp.dto.timeSheetDTO.TimeSheetDTO;

public interface TimeSheetAPIService {

	TimeSheetDTO createTimeSheet(TimeSheetDTO timeSheetDTO);

	TimeSheetDTO updateTimeSheet(TimeSheetDTO timeSheetDTO);

	TimeSheetDTO getTimeSheetRecord(long timeSheetId);

	List<TimeSheetDTO> getTimeSheetRecords();

	TimeSheetDTO deleteTimeSheet(long deletedTimeSheetId);

}
