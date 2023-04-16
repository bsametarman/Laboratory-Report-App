package com.project.LaboratoryReportApp.business.rules;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.project.LaboratoryReportApp.core.utilities.exceptions.MethodArgumentNotValidException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LaborantValidationRules {
	
	public void checkIfLaborantNameIsValid(String name) {
		if(name == null) {
			throw new MethodArgumentNotValidException("Name cannot be null!");
		}
		else if(name.length() < 2 || name.length() > 25) {
			throw new MethodArgumentNotValidException("Name must be between 2 and 25 characters.");
		}
	}
	
	public void checkIfLaborantSurnameIsValid(String surname) {
		if(surname == null) {
			throw new MethodArgumentNotValidException("Surname cannot be null!");
		}
		else if(!StringUtils.isAnyBlank(surname)) {
			throw new MethodArgumentNotValidException("Surname cannot have spaces!");
		}
		else if(surname.length() < 2 || surname.length() > 25) {
			throw new MethodArgumentNotValidException("Surname must be between 2 and 25 characters.");
		}
	}
	
	public void checkIfLaborantIdentityNumberIsValid(String identityNumber) {
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
	
	public void checkIfLaborantHospitalIdentityNumberIsValid(String hospitalIdentityNumber) {
		if(hospitalIdentityNumber == null) {
			throw new MethodArgumentNotValidException("Hospital identity number cannot be null!");
		}
		else if(hospitalIdentityNumber.length() != 7) {
			throw new MethodArgumentNotValidException("Hospital identity number must be 7 characters.");
		}
	}
	
	public void checkIfLaborantAddressIsValid(String address) {
		if(address == null) {
			throw new MethodArgumentNotValidException("Address cannot be null!");
		}
		else if(address.length() < 3 || address.length() > 250) {
			throw new MethodArgumentNotValidException("Address must be between 3 and 250 characters.");
		}
	}
	
	public void checkIfLaborantPhoneNumberIsValid(String phoneNumber) {
		if(phoneNumber == null) {
			throw new MethodArgumentNotValidException("Phone number cannot be null!");
		}
		else if(!StringUtils.isNumeric(phoneNumber)) {
			throw new MethodArgumentNotValidException("Phone number must consist of numbers!");
		}
		else if(phoneNumber.length() != 10) {
			throw new MethodArgumentNotValidException("Phone number must be 10 characters.");
		}
	}
}
