package com.project.LaboratoryReportApp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.LaboratoryReportApp.business.abstracts.LaborantService;
import com.project.LaboratoryReportApp.business.requests.CreateLaborantRequest;
import com.project.LaboratoryReportApp.business.requests.UpdateLaborantRequest;
import com.project.LaboratoryReportApp.business.responses.GetAllActiveLaborantsResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsByHospitalIdentityNumberResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsByIdentityNumberResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsByNameOrSurnameResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdLaborantResponse;
import com.project.LaboratoryReportApp.core.utilities.results.DataResult;

@CrossOrigin
@RestController
@RequestMapping("/api/laborants")
public class LaborantController {
	
	private LaborantService laborantService;
	
	@Autowired
	public LaborantController(LaborantService laborantService) {
		super();
		this.laborantService = laborantService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllLaborantsResponse>> getAll() {
		return laborantService.getAll();
	}
	
	@GetMapping("/getAllActiveLaborants")
	public DataResult<List<GetAllActiveLaborantsResponse>> getAllActiveLaborants() {
		return laborantService.getAllActiveLaborants();
	}
	
	@GetMapping("/getById/{laborantId}")
	public DataResult<GetByIdLaborantResponse> getById(@PathVariable("laborantId") int laborantId) {
		return laborantService.getById(laborantId);
	}
	
	@GetMapping("/getByNameOrSurname/{name}/{surname}")
	public DataResult<List<GetAllLaborantsByNameOrSurnameResponse>> getByNameOrSurname(@PathVariable("name") String name, @PathVariable("surname") String surname) {
		return laborantService.getAllByNameOrSurname(name, surname);
	}
	
	@GetMapping("/getByHostpitalIdentityNumber/{hospital_identity_number}")
	public DataResult<List<GetAllLaborantsByHospitalIdentityNumberResponse>> getByHostpitalIdentityNumber(@PathVariable("hospital_identity_number") String hospitalIdentityNumber) {
		return laborantService.getAllByHospitalIdentityNumber(hospitalIdentityNumber);
	}
	
	@GetMapping("/getByLaborantIdentityNumber/{laborant_identity_number}")
	public DataResult<List<GetAllLaborantsByIdentityNumberResponse>> getByLaborantIdentityNumber(@PathVariable("laborant_identity_number") String laborantIdentityNumber) {
		return laborantService.getAllByLaborantIdentityNumber(laborantIdentityNumber);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public DataResult<CreateLaborantRequest> add(@RequestBody CreateLaborantRequest laborant) {
		return laborantService.add(laborant);
	}
	
	@PutMapping("/changeActiveState/{laborant_id}")
	public void changeActiveState(@PathVariable("laborant_id") int laborantId) {
		laborantService.changeActiveState(laborantId);
	}
	
	@DeleteMapping("/delete/{laborant_id}")
	public void delete(@PathVariable("laborant_id") int laborantId) {
		laborantService.delete(laborantId);
	}
	
	@PutMapping("/update")
	public DataResult<UpdateLaborantRequest> update(@RequestBody UpdateLaborantRequest laborant) {
		return laborantService.update(laborant);
	}
	
}
