package com.project.LaboratoryReportApp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.LaboratoryReportApp.business.abstracts.ReportService;
import com.project.LaboratoryReportApp.business.requests.CreateReportRequest;
import com.project.LaboratoryReportApp.business.requests.UpdateReportRequest;
import com.project.LaboratoryReportApp.business.responses.GetByPatientIdentityNumberReportResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsByPatientNameOrSurnameResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsReportDateAscResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsReportDateDescResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdReportResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/reports")
public class ReportController {
	
	private ReportService reportService;
	
	@Autowired
	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllReportsResponse> getAll() {
		return reportService.getAll();
	}
	
	@GetMapping("/getAllReportDateDesc")
	public List<GetAllReportsReportDateDescResponse> getAllReportDateDesc() {
		return reportService.getAllReportDateDesc();
	}
	
	@GetMapping("/getAllReportDateAsc")
	public List<GetAllReportsReportDateAscResponse> getAllReportDateAsc() {
		return reportService.getAllReportDateAsc();
	}
	
	@GetMapping("/getById/{report_id}")
	public GetByIdReportResponse getById(@PathVariable("report_id") int reportId) {
		return reportService.getById(reportId);
	}
	
	@GetMapping("/getByNameOrSurname/{patient_name}/{patient_surname}")
	public List<GetAllReportsByPatientNameOrSurnameResponse> getByNameOrSurname(@PathVariable("patient_name") String patientName, @PathVariable("patient_surname") String patientSurname) {
		return reportService.getAllByPatientNameOrSurname(patientName, patientSurname);
	}
	
	@GetMapping("/getByIdentityNumber/{identity_number}")
	public List<GetByPatientIdentityNumberReportResponse> getByIdentityNumber(@PathVariable("identity_number") String identityNumber) {
		return reportService.getAllByPatientIdentityNumber(identityNumber);
	}
	
	@PostMapping("/add")
	public CreateReportRequest add(@RequestBody CreateReportRequest report) {
		return reportService.add(report);
	}
	
	@DeleteMapping("/delete")
	public void delete(int reportId) {
		reportService.delete(reportId);
	}
	
	@PutMapping("/update")
	public UpdateReportRequest update(@RequestBody UpdateReportRequest report) {
		return reportService.update(report);
	}
}
