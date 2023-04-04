package com.project.LaboratoryReportApp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.LaboratoryReportApp.business.abstracts.LaborantService;
import com.project.LaboratoryReportApp.business.requests.CreateLaborantRequest;
import com.project.LaboratoryReportApp.business.requests.UpdateLaborantRequest;
import com.project.LaboratoryReportApp.business.responses.GetAllLaborantsResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdLaborantResponse;

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
	public List<GetAllLaborantsResponse> getAll() {
		return laborantService.getAll();
	}
	
	@GetMapping("/getById/{laborantId}")
	public GetByIdLaborantResponse getById(@PathVariable("laborantId") int laborantId) {
		return laborantService.getById(laborantId);
	}
	
	@PostMapping("/add")
	public CreateLaborantRequest add(@RequestBody CreateLaborantRequest laborant) {
		return laborantService.add(laborant);
	}
	
	@DeleteMapping("/delete")
	public void delete(int laborantId) {
		laborantService.delete(laborantId);
	}
	
	@PutMapping("/update")
	public UpdateLaborantRequest update(@RequestBody UpdateLaborantRequest laborant) {
		return laborantService.update(laborant);
	}
	
}
