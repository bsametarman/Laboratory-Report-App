package com.project.LaboratoryReportApp.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {
	
	public ErrorDataResult() {
		super(false, null, null);
	}
	
	public ErrorDataResult(T data) {
		super(false, data);
	}
	
	public ErrorDataResult(String message) {
		super(false, message, null);
	}
	
	public ErrorDataResult(T data, String message) {
		super(false, message, data);
	}
}
