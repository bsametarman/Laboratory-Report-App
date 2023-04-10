package com.project.LaboratoryReportApp.business.responses;

import java.util.Date;
import java.util.List;

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
	private int laborantId;
	private String laborantName;
	private String laborantSurname;
	private String laborantAddress;
	private List<GetAllImagesResponse> images;
}
