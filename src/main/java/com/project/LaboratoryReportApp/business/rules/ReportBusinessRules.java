package com.project.LaboratoryReportApp.business.rules;

import org.springframework.stereotype.Service;

import com.project.LaboratoryReportApp.core.utilities.exceptions.BusinessException;
import com.project.LaboratoryReportApp.dataAccess.abstracts.ReportDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReportBusinessRules {
	private ReportDao reportDao;
	
	public void checkIfFileNoExists(String fileNo) {
		if(this.reportDao.existsByFileNo(fileNo)) {
			throw new BusinessException("File no must be different!");
		}
	}
	
}
