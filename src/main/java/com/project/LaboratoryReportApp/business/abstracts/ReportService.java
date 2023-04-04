package com.project.LaboratoryReportApp.business.abstracts;

import java.util.List;

import com.project.LaboratoryReportApp.business.requests.CreateReportRequest;
import com.project.LaboratoryReportApp.business.requests.UpdateReportRequest;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdReportResponse;

public interface ReportService {
	public List<GetAllReportsResponse> getAll();
	public GetByIdReportResponse getById(int reportId);
	public CreateReportRequest add(CreateReportRequest report);
	public void delete(int reportId);
	public UpdateReportRequest update(UpdateReportRequest report);
}
