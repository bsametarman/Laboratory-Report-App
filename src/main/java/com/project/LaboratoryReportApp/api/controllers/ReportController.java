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

import com.project.LaboratoryReportApp.business.abstracts.ReportService;
import com.project.LaboratoryReportApp.business.requests.CreateReportRequest;
import com.project.LaboratoryReportApp.business.requests.UpdateReportRequest;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdReportResponse;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
	
	private ReportService reportService;
	
	@Autowired
	public ReportController(ReportService reportService) {
		super();
		this.reportService = reportService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllReportsResponse> getAll() {
		return reportService.getAll();
	}
	
	@GetMapping("/getById/{reportId}")
	public GetByIdReportResponse getById(@PathVariable("reportId") int reportId) {
		return reportService.getById(reportId);
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
