package com.project.LaboratoryReportApp.business.rules;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.project.LaboratoryReportApp.core.utilities.exceptions.MethodArgumentNotValidException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReportValidationRules {
	
	public void checkIfFileNoIsValid(String fileNo) {
		if(fileNo == null) {
			throw new MethodArgumentNotValidException("File no cannot be null!");
		}
		else if(fileNo.length() < 4 || fileNo.length() > 10) {
			throw new MethodArgumentNotValidException("File no must be between 4 and 10 characters.");
		}
	}
	
	public void checkIfPatientNameIsValid(String name) {
		if(name == null) {
			throw new MethodArgumentNotValidException("Name cannot be null!");
		}
		else if(name.length() <= 2 || name.length() >= 25) {
			throw new MethodArgumentNotValidException("Name must be between 2 and 25 characters.");
		}
	}
	
	public void checkIfPatientSurnameIsValid(String surname) {
		if(surname == null) {
			throw new MethodArgumentNotValidException("Surname cannot be null!");
		}
		else if(StringUtils.isAnyBlank(surname)) {
			throw new MethodArgumentNotValidException("Surname cannot have spaces!");
		}
		else if(surname.length() <= 2 || surname.length() >= 25) {
			throw new MethodArgumentNotValidException("Surname must be between 2 and 25 characters.");
		}
	}
	
	public void checkIfPatientIdentityNumberIsValid(String identityNumber) {
		if(identityNumber == null) {
			throw new MethodArgumentNotValidException("Identity number cannot be null!");
		}
		else if(!StringUtils.isNumeric(identityNumber)) {
			throw new MethodArgumentNotValidException("Identity number must consist of numbers!");
		}
		else if(identityNumber.length() != 11) {
			throw new MethodArgumentNotValidException("Identity number must be 11 characters.");
		}
	}
	
	public void checkIfDiagnosticTitleIsValid(String diagnosticTitle) {
		if(diagnosticTitle == null) {
			throw new MethodArgumentNotValidException("Diagnostic title cannot be null!");
		}
		else if(diagnosticTitle.length() < 5 || diagnosticTitle.length() > 50) {
			throw new MethodArgumentNotValidException("Diagnostic title must be between 5 and 50 characters.");
		}
	}
	
	public void checkIfDiagnosticDetailIsValid(String diagnosticDetails) {
		if(diagnosticDetails == null) {
			throw new MethodArgumentNotValidException("Diagnosic detail cannot be null!");
		}
		else if(diagnosticDetails.length() < 10) {
			throw new MethodArgumentNotValidException("Diagnosic detail must be more than 10 characters.");
		}
	}
	
}
