package com.project.LaboratoryReportApp.business.abstracts;

import java.util.List;

import com.project.LaboratoryReportApp.entities.concretes.Report;

public interface ReportService {
	public List<Report> getAll();
	public Report getById(int reportId);
	public Report add(Report report);
	public void delete(int reportId);
	public Report update(Report report);
}
