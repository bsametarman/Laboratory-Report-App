package com.project.LaboratoryReportApp.business.requests;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReportRequest {
	private int id;
	private String fileNo;
	private String patientName;
	private String patientSurname;
	private String patientIdentityNumber;
	private String diagnosticTitle;
	private String diagnosticDetail;
	private Date reportDate;
	private int imageId;
	private int laborantId;
}
