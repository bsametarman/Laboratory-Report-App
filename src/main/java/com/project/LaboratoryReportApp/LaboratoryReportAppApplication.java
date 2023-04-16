package com.project.LaboratoryReportApp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.LaboratoryReportApp.core.utilities.exceptions.BusinessException;
import com.project.LaboratoryReportApp.core.utilities.exceptions.MethodArgumentNotValidException;
import com.project.LaboratoryReportApp.core.utilities.exceptions.ProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class LaboratoryReportAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaboratoryReportAppApplication.class, args);
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		
		return problemDetails;
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(methodArgumentNotValidException.getMessage());
		
		return problemDetails;
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
}
