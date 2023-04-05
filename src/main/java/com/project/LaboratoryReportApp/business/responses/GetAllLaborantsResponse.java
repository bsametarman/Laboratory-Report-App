package com.project.LaboratoryReportApp.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLaborantsResponse {
	private int id;
	private String laborantName;
	private String laborantSurname;
	private String identityNumber;
	private String hospitalIdentityNumber;
	private String address;
	private String phoneNumber;
	private List<GetAllReportsResponse> reports;
}
