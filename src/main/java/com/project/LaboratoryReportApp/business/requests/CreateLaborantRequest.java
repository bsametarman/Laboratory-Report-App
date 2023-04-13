package com.project.LaboratoryReportApp.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLaborantRequest {
	private int id;
	private String laborantName;
	private String laborantSurname;
	private String laborantIdentityNumber;
	private String hospitalIdentityNumber;
	private String address;
	private String phoneNumber;
}
