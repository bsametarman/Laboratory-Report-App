package com.project.LaboratoryReportApp.business.abstracts;

import java.util.List;

import com.project.LaboratoryReportApp.business.requests.CreateLaborantRequest;
import com.project.LaboratoryReportApp.business.requests.UpdateLaborantRequest;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsByHospitalIdentityNumberResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsByIdentityNumberResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsByNameOrSurnameResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdLaborantResponse;

public interface LaborantService {
	List<GetAllLaborantsResponse> getAll();
	GetByIdLaborantResponse getById(int laborantId);
	CreateLaborantRequest add(CreateLaborantRequest laborantRequest);
	void delete(int laborantId);
	UpdateLaborantRequest update(UpdateLaborantRequest laborantRequest);
	List<GetAllLaborantsByNameOrSurnameResponse> getAllByNameOrSurname(String name, String surname);
	List<GetAllLaborantsByHospitalIdentityNumberResponse> getAllByHospitalIdentityNumber(String hospitalIdentityNumber);
	List<GetAllLaborantsByIdentityNumberResponse> getAllByLaborantIdentityNumber(String laborantIdentityNumber);
}
