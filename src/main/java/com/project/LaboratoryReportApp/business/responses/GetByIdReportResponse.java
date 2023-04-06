package com.project.LaboratoryReportApp.business.responses;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdReportResponse {
	private int id;
	private String fileNo;
	private String patientName;
	private String patientSurname;
	private String patientIdentityNumber;
	private String diagnosticTitle;
	private String diagnosticDetail;
	private Date reportDate;
	private String imageName;
	private String imageType;
	private String laborantName;
	private String laborantSurname;
	private String laborantAddress;
	private byte[] imageData;
}
