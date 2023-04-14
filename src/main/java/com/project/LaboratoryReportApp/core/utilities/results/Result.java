package com.project.LaboratoryReportApp.core.utilities.results;

public class Result {
	private boolean isSuccess;
	private String message;
	
	public Result(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public Result(boolean isSuccess, String message) {
		this(isSuccess);
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public boolean isSuccess() {
		return this.isSuccess;
	}
}
