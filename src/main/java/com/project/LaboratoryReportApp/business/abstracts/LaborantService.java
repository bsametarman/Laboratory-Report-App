package com.project.LaboratoryReportApp.business.abstracts;

import java.util.List;

import com.project.LaboratoryReportApp.business.requests.CreateLaborantRequest;
import com.project.LaboratoryReportApp.business.requests.UpdateLaborantRequest;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdLaborantResponse;

public interface LaborantService {
	public List<GetAllLaborantsResponse> getAll();
	public GetByIdLaborantResponse getById(int laborantId);
	public CreateLaborantRequest add(CreateLaborantRequest laborantRequest);
	public void delete(int laborantId);
	public UpdateLaborantRequest update(UpdateLaborantRequest laborantRequest);
}
