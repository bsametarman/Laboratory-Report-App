package com.project.LaboratoryReportApp.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LaboratoryReportApp.business.abstracts.LaborantService;
import com.project.LaboratoryReportApp.business.requests.CreateLaborantRequest;
import com.project.LaboratoryReportApp.business.requests.UpdateLaborantRequest;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdLaborantResponse;
import com.project.LaboratoryReportApp.core.utilities.mappers.ModelMapperService;
import com.project.LaboratoryReportApp.dataAccess.abstracts.LaborantDao;
import com.project.LaboratoryReportApp.entities.concretes.Laborant;

@Service
public class LaborantManager implements LaborantService{
	
	private LaborantDao laborantDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public LaborantManager(LaborantDao laborantDao, ModelMapperService modelMapperService) {
		this.laborantDao = laborantDao;
		this.modelMapperService = modelMapperService;
	}
	
	@Override
	public List<GetAllLaborantsResponse> getAll() {
		List<Laborant> laborants = laborantDao.findAll();
		List<GetAllLaborantsResponse> laborantsResponse = laborants.stream().map(laborant -> this.modelMapperService.forResponse().map(laborant, GetAllLaborantsResponse.class)).collect(Collectors.toList());
		
		return laborantsResponse;
	}

	@Override
	public GetByIdLaborantResponse getById(int laborantId) {
		Laborant laborant = laborantDao.findById(laborantId).orElseThrow();
		GetByIdLaborantResponse laborantResponse = this.modelMapperService.forResponse().map(laborant, GetByIdLaborantResponse.class);
		
		return laborantResponse;
	}

	@Override
	public CreateLaborantRequest add(CreateLaborantRequest laborantRequest) {
		Laborant laborant = this.modelMapperService.forRequest().map(laborantRequest, Laborant.class);
		this.laborantDao.save(laborant);
		return laborantRequest;
	}

	@Override
	public void delete(int laborantId) {
		laborantDao.deleteById(laborantId);
	}

	@Override
	public UpdateLaborantRequest update(UpdateLaborantRequest laborantRequest) {
		Laborant laborant = this.modelMapperService.forRequest().map(laborantRequest, Laborant.class);
		this.laborantDao.save(laborant);
		return laborantRequest;
	}

}
