package com.project.LaboratoryReportApp.business.rules;

import org.springframework.stereotype.Service;

import com.project.LaboratoryReportApp.core.utilities.exceptions.BusinessException;
import com.project.LaboratoryReportApp.dataAccess.abstracts.LaborantDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LaborantBusinessRules {
	private LaborantDao laborantDao;
	
	public void checkIfLaborantNameAndSurnameExists(String name, String surname) {
		if(this.laborantDao.existsByLaborantNameIgnoreCaseAndLaborantSurnameIgnoreCase(name, surname)) {
			throw new BusinessException("Laborant already exist!");
		}
	}
	
	public void checkIfLaborantIdentityNumberExists(String identityNumber) {
		if(this.laborantDao.existsByLaborantIdentityNumber(identityNumber)) {
			throw new BusinessException("Identity number must be different!");
		}
	}
}
