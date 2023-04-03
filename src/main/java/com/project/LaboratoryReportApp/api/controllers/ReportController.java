package com.project.LaboratoryReportApp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.LaboratoryReportApp.business.abstracts.ReportService;
import com.project.LaboratoryReportApp.entities.concretes.Report;

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
	public List<Report> getAll() {
		return reportService.getAll();
	}
	
	@GetMapping("/getById/{reportId}")
	public Report getById(@PathVariable("reportId") int reportId) {
		return reportService.getById(reportId);
	}
	
	@PostMapping("/add")
	public Report add(Report report) {
		return reportService.add(report);
	}
	
	@PostMapping("/delete")
	public void delete(int reportId) {
		reportService.delete(reportId);
	}
	
	@PostMapping("/update")
	public Report update(Report report) {
		return reportService.update(report);
	}
}
