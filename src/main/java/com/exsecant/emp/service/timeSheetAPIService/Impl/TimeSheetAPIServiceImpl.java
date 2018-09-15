package com.exsecant.emp.service.timeSheetAPIService.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exsecant.emp.dao.timeSheetDAO.TimeSheetDAO;
import com.exsecant.emp.dto.timeSheetDTO.TimeSheetDTO;
import com.exsecant.emp.entity.timeSheet.TblTimeSheet;
import com.exsecant.emp.service.timeSheetAPIService.TimeSheetAPIService;

@Service("timeSheetAPIService")
public class TimeSheetAPIServiceImpl implements TimeSheetAPIService {

	@Autowired
	private TimeSheetDAO timeSheetDAO;

	@Override
	public TimeSheetDTO createTimeSheet(TimeSheetDTO timeSheetDTO) {

		TblTimeSheet dbTimeSheet = new TblTimeSheet();

		dbTimeSheet.setId(timeSheetDTO.getId());
		dbTimeSheet.setProject(timeSheetDTO.getProject());
		dbTimeSheet.setTask(timeSheetDTO.getTask());
		dbTimeSheet.setInputAsDuration(timeSheetDTO.getInputAsDuration());
		dbTimeSheet.setInputAsTimeInterval(timeSheetDTO.getInputAsTimeInterval());
		dbTimeSheet.setDiscription(timeSheetDTO.getDiscription());
		dbTimeSheet.setUser(timeSheetDTO.getUser());

		TblTimeSheet timeSheetObj = timeSheetDAO.createTimeSheet(dbTimeSheet);

		TimeSheetDTO timeSheetDTOToReturn = new TimeSheetDTO();

		timeSheetDTOToReturn.setId(timeSheetObj.getId());
		timeSheetDTOToReturn.setProject(timeSheetObj.getProject());
		timeSheetDTOToReturn.setTask(timeSheetObj.getTask());
		timeSheetDTOToReturn.setInputAsDuration(timeSheetObj.getInputAsDuration());
		timeSheetDTOToReturn.setInputAsTimeInterval(timeSheetObj.getInputAsTimeInterval());
		timeSheetDTOToReturn.setDiscription(timeSheetObj.getDiscription());
		timeSheetDTOToReturn.setUser(timeSheetObj.getUser());

		return timeSheetDTOToReturn;
	}

	@Override
	public TimeSheetDTO updateTimeSheet(TimeSheetDTO timeSheetDTO) {

		TblTimeSheet dbTimeSheet = new TblTimeSheet();

		dbTimeSheet.setId(timeSheetDTO.getId());
		dbTimeSheet.setProject(timeSheetDTO.getProject());
		dbTimeSheet.setTask(timeSheetDTO.getTask());
		dbTimeSheet.setInputAsDuration(timeSheetDTO.getInputAsDuration());
		dbTimeSheet.setInputAsTimeInterval(timeSheetDTO.getInputAsTimeInterval());
		dbTimeSheet.setDiscription(timeSheetDTO.getDiscription());
		dbTimeSheet.setUser(timeSheetDTO.getUser());

		TblTimeSheet timeSheetObj = timeSheetDAO.updateTimeSheet(dbTimeSheet);

		TimeSheetDTO timeSheetDTOToReturn = new TimeSheetDTO();

		timeSheetDTOToReturn.setId(timeSheetObj.getId());
		timeSheetDTOToReturn.setProject(timeSheetObj.getProject());
		timeSheetDTOToReturn.setTask(timeSheetObj.getTask());
		timeSheetDTOToReturn.setInputAsDuration(timeSheetObj.getInputAsDuration());
		timeSheetDTOToReturn.setInputAsTimeInterval(timeSheetObj.getInputAsTimeInterval());
		timeSheetDTOToReturn.setDiscription(timeSheetObj.getDiscription());
		timeSheetDTOToReturn.setUser(timeSheetObj.getUser());

		return timeSheetDTOToReturn;
	}

	@Override
	public TimeSheetDTO getTimeSheetRecord(long timeSheetId) {

		Boolean isTimeSheetExist = timeSheetDAO.timeSheetExist(timeSheetId);
		TimeSheetDTO timeSheetDTOToReturn = new TimeSheetDTO();

		if (isTimeSheetExist) {
			TblTimeSheet timeSheetObj = timeSheetDAO.getTimeSheetRecord(timeSheetId);
			timeSheetDTOToReturn.setId(timeSheetObj.getId());
			timeSheetDTOToReturn.setProject(timeSheetObj.getProject());
			timeSheetDTOToReturn.setTask(timeSheetObj.getTask());
			timeSheetDTOToReturn.setInputAsDuration(timeSheetObj.getInputAsDuration());
			timeSheetDTOToReturn.setInputAsTimeInterval(timeSheetObj.getInputAsTimeInterval());
			timeSheetDTOToReturn.setDiscription(timeSheetObj.getDiscription());
			timeSheetDTOToReturn.setUser(timeSheetObj.getUser());

		} else {

		}
		return timeSheetDTOToReturn;
	}

	@Override
	public List<TimeSheetDTO> getTimeSheetRecords() {
		List<TblTimeSheet> timeSheetList = timeSheetDAO.getTimeSheetRecords();

		@SuppressWarnings("unused")
		List<TimeSheetDTO> timeSheetDTOToReturn = new ArrayList<>();

		for (TblTimeSheet timeSheetObj : timeSheetList) {
			TimeSheetDTO timeSheetDTO = new TimeSheetDTO();
			timeSheetDTO.setId(timeSheetObj.getId());
			timeSheetDTO.setProject(timeSheetObj.getProject());
			timeSheetDTO.setTask(timeSheetObj.getTask());
			timeSheetDTO.setInputAsDuration(timeSheetObj.getInputAsDuration());
			timeSheetDTO.setInputAsTimeInterval(timeSheetObj.getInputAsTimeInterval());
			timeSheetDTO.setDiscription(timeSheetObj.getDiscription());
			timeSheetDTO.setUser(timeSheetObj.getUser());
			timeSheetDTOToReturn.add(timeSheetDTO);
		}

		return timeSheetDTOToReturn;
	}

	@Override
	public TimeSheetDTO deleteTimeSheet(long deletedTimeSheetId) {
		TblTimeSheet dbTimeSheet = timeSheetDAO.getTimeSheetRecord(deletedTimeSheetId);
		TimeSheetDTO timeSheetDTOToReturn = null;

		Boolean isDeletedTimeSheet = timeSheetDAO.deleteTimeSheet(deletedTimeSheetId);

		if (isDeletedTimeSheet) {
			timeSheetDTOToReturn = new TimeSheetDTO();
			timeSheetDTOToReturn.setId(dbTimeSheet.getId());
			timeSheetDTOToReturn.setProject(dbTimeSheet.getProject());
			timeSheetDTOToReturn.setTask(dbTimeSheet.getTask());
			timeSheetDTOToReturn.setInputAsDuration(dbTimeSheet.getInputAsDuration());
			timeSheetDTOToReturn.setInputAsTimeInterval(dbTimeSheet.getInputAsTimeInterval());
			timeSheetDTOToReturn.setDiscription(dbTimeSheet.getDiscription());
			timeSheetDTOToReturn.setUser(dbTimeSheet.getUser());
		}
		return timeSheetDTOToReturn;
	}

}
