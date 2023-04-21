package com.project.LaboratoryReportApp.business.abstracts;

import java.util.List;

import com.project.LaboratoryReportApp.business.requests.CreateReportRequest;
import com.project.LaboratoryReportApp.business.requests.UpdateReportRequest;
import com.project.LaboratoryReportApp.business.responses.GetByPatientIdentityNumberReportResponse;
import com.project.LaboratoryReportApp.core.utilities.results.DataResult;
import com.project.LaboratoryReportApp.business.responses.GetAllActiveReportsResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsByPatientNameOrSurnameResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsReportDateAscResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsReportDateDescResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdReportResponse;

public interface ReportService {
	DataResult<List<GetAllReportsResponse>> getAll();
	DataResult<List<GetAllActiveReportsResponse>> getAllActiveReports();
	DataResult<GetByIdReportResponse> getById(int reportId);
	DataResult<CreateReportRequest> add(CreateReportRequest report);
	void delete(int reportId);
	void changeActiveState(int reportId);
	DataResult<UpdateReportRequest> update(UpdateReportRequest report);
	DataResult<List<GetAllReportsByPatientNameOrSurnameResponse>> getAllByPatientNameOrSurname(String patientName, String patientSurname);
	DataResult<List<GetByPatientIdentityNumberReportResponse>> getAllByPatientIdentityNumber(String identityNumber);
	DataResult<List<GetAllReportsReportDateDescResponse>> getAllReportDateDesc();
	DataResult<List<GetAllReportsReportDateAscResponse>> getAllReportDateAsc();
}
