package com.project.LaboratoryReportApp.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LaboratoryReportApp.business.abstracts.LaborantService;
import com.project.LaboratoryReportApp.business.requests.CreateLaborantRequest;
import com.project.LaboratoryReportApp.business.requests.UpdateLaborantRequest;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsByHospitalIdentityNumberResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsByIdentityNumberResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsByNameOrSurnameResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdLaborantResponse;
import com.project.LaboratoryReportApp.core.utilities.mappers.ModelMapperService;
import com.project.LaboratoryReportApp.core.utilities.results.DataResult;
import com.project.LaboratoryReportApp.core.utilities.results.ErrorDataResult;
import com.project.LaboratoryReportApp.core.utilities.results.SuccessDataResult;
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
	public DataResult<List<GetAllLaborantsResponse>> getAll() {
		try {
			List<Laborant> laborants = laborantDao.findAll();
			List<GetAllLaborantsResponse> laborantsResponse = laborants.stream().map(laborant -> this.modelMapperService.forResponse().map(laborant, GetAllLaborantsResponse.class)).collect(Collectors.toList());
			
			return new SuccessDataResult<List<GetAllLaborantsResponse>>(laborantsResponse, "Successfully listed!");
			
		} catch (Exception e) {
			return new ErrorDataResult<List<GetAllLaborantsResponse>>(e.getMessage());
		}
		
	}

	@Override
	public DataResult<GetByIdLaborantResponse> getById(int laborantId) {
		try {
			Laborant laborant = laborantDao.findById(laborantId).orElseThrow();
			GetByIdLaborantResponse laborantResponse = this.modelMapperService.forResponse().map(laborant, GetByIdLaborantResponse.class);
			
			return new SuccessDataResult<GetByIdLaborantResponse>(laborantResponse, "Successfully listed!");
			
		} catch (Exception e) {
			return new ErrorDataResult<GetByIdLaborantResponse>(e.getMessage());
		}
		
	}

	@Override
	public DataResult<CreateLaborantRequest> add(CreateLaborantRequest laborantRequest) {
		try {
			Laborant laborant = this.modelMapperService.forRequest().map(laborantRequest, Laborant.class);
			this.laborantDao.save(laborant);
			
			return new SuccessDataResult<CreateLaborantRequest>(laborantRequest, "Successfully added!");
			
		} catch (Exception e) {
			return new ErrorDataResult<CreateLaborantRequest>(e.getMessage());
		}
		
	}

	@Override
	public void delete(int laborantId) {
		laborantDao.deleteById(laborantId);
	}

	@Override
	public DataResult<UpdateLaborantRequest> update(UpdateLaborantRequest laborantRequest) {
		try {
			Laborant laborant = this.modelMapperService.forRequest().map(laborantRequest, Laborant.class);
			this.laborantDao.save(laborant);
			
			return new SuccessDataResult<UpdateLaborantRequest>(laborantRequest, "Successfully updated!");
			
		} catch (Exception e) {
			return new ErrorDataResult<UpdateLaborantRequest>(e.getMessage());
		}
		
	}

	@Override
	public DataResult<List<GetAllLaborantsByNameOrSurnameResponse>> getAllByNameOrSurname(String name, String surname) {
		try {
			List<Laborant> laborants = this.laborantDao.findAllByLaborantNameIgnoreCaseOrLaborantSurnameIgnoreCase(name, surname);
			List<GetAllLaborantsByNameOrSurnameResponse> laborantResponse = laborants.stream().map(laborant -> this.modelMapperService.forResponse().map(laborant, GetAllLaborantsByNameOrSurnameResponse.class)).collect(Collectors.toList());
			
			return new SuccessDataResult<List<GetAllLaborantsByNameOrSurnameResponse>>(laborantResponse, "Successfully listed!");
			
		} catch (Exception e) {
			return new ErrorDataResult<List<GetAllLaborantsByNameOrSurnameResponse>>(e.getMessage());
		}
		
	}

	@Override
	public DataResult<List<GetAllLaborantsByHospitalIdentityNumberResponse>> getAllByHospitalIdentityNumber(
			String hospitalIdentityNumber) {
		try {
			List<Laborant> laborants = this.laborantDao.findAllByHospitalIdentityNumberIgnoreCase(hospitalIdentityNumber);
			List<GetAllLaborantsByHospitalIdentityNumberResponse> laborantResponse = laborants.stream().map(laborant -> this.modelMapperService.forResponse().map(laborant, GetAllLaborantsByHospitalIdentityNumberResponse.class)).collect(Collectors.toList());
			
			return new SuccessDataResult<List<GetAllLaborantsByHospitalIdentityNumberResponse>>(laborantResponse, "Successfully listed!");
		
		} catch (Exception e) {
			return new ErrorDataResult<List<GetAllLaborantsByHospitalIdentityNumberResponse>>(e.getMessage());
		}
		
	}

	@Override
	public DataResult<List<GetAllLaborantsByIdentityNumberResponse>> getAllByLaborantIdentityNumber(
			String laborantIdentityNumber) {
		try {
			List<Laborant> laborants = this.laborantDao.findAllByLaborantIdentityNumberIgnoreCase(laborantIdentityNumber);
			List<GetAllLaborantsByIdentityNumberResponse> laborantResponse = laborants.stream().map(laborant -> this.modelMapperService.forResponse().map(laborant, GetAllLaborantsByIdentityNumberResponse.class)).collect(Collectors.toList());
			
			return new SuccessDataResult<List<GetAllLaborantsByIdentityNumberResponse>>(laborantResponse, "Successfully listed!");
		
		} catch (Exception e) {
			return new ErrorDataResult<List<GetAllLaborantsByIdentityNumberResponse>>(e.getMessage());
		}
		
	}

}
