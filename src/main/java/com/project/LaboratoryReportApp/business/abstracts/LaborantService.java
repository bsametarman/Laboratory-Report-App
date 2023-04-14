package com.project.LaboratoryReportApp.business.abstracts;

import java.util.List;

import com.project.LaboratoryReportApp.business.requests.CreateLaborantRequest;
import com.project.LaboratoryReportApp.business.requests.UpdateLaborantRequest;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsByHospitalIdentityNumberResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsByIdentityNumberResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsByNameOrSurnameResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdLaborantResponse;
import com.project.LaboratoryReportApp.core.utilities.results.DataResult;

public interface LaborantService {
	DataResult<List<GetAllLaborantsResponse>> getAll();
	DataResult<GetByIdLaborantResponse> getById(int laborantId);
	DataResult<CreateLaborantRequest> add(CreateLaborantRequest laborantRequest);
	void delete(int laborantId);
	DataResult<UpdateLaborantRequest> update(UpdateLaborantRequest laborantRequest);
	DataResult<List<GetAllLaborantsByNameOrSurnameResponse>> getAllByNameOrSurname(String name, String surname);
	DataResult<List<GetAllLaborantsByHospitalIdentityNumberResponse>> getAllByHospitalIdentityNumber(String hospitalIdentityNumber);
	DataResult<List<GetAllLaborantsByIdentityNumberResponse>> getAllByLaborantIdentityNumber(String laborantIdentityNumber);
}
