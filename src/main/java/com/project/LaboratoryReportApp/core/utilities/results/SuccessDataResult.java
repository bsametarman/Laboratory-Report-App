package com.project.LaboratoryReportApp.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {
	
	public SuccessDataResult() {
		super(true, null, null);
	}
	
	public SuccessDataResult(T data) {
		super(true, data);
	}
	
	public SuccessDataResult(String message) {
		super(true, message, null);
	}
	
	public SuccessDataResult(T data, String message) {
		super(true, message, data);
	}
}
