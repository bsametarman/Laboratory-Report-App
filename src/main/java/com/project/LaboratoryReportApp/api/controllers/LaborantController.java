package com.project.LaboratoryReportApp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.LaboratoryReportApp.business.abstracts.LaborantService;
import com.project.LaboratoryReportApp.entities.concretes.Laborant;

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
	public List<Laborant> getAll() {
		return laborantService.getAll();
	}
	
	@GetMapping("/getById/{laborantId}")
	public Laborant getById(@PathVariable("laborantId") int laborantId) {
		return laborantService.getById(laborantId);
	}
	
	@PostMapping("/add")
	public Laborant add(Laborant laborant) {
		return laborantService.add(laborant);
	}
	
	@PostMapping("/delete")
	public void delete(int laborantId) {
		laborantService.delete(laborantId);
	}
	
	@PostMapping("/update")
	public Laborant update(Laborant laborant) {
		return laborantService.update(laborant);
	}
	
}
