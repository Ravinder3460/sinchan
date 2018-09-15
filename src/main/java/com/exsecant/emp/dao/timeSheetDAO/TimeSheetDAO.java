package com.exsecant.emp.dao.timeSheetDAO;

import java.util.List;

import com.exsecant.emp.entity.timeSheet.TblTimeSheet;

public interface TimeSheetDAO {

	TblTimeSheet createTimeSheet(TblTimeSheet dbTimeSheet);

	TblTimeSheet updateTimeSheet(TblTimeSheet dbTimeSheet);

	TblTimeSheet getTimeSheetRecord(long timeSheetId);

	Boolean deleteTimeSheet(long deletedTimeSheetId);

	List<TblTimeSheet> getTimeSheetRecords();

	Boolean timeSheetExist(long timeSheetId);
}
