package com.project.LaboratoryReportApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LaboratoryReportApp.business.abstracts.ReportService;
import com.project.LaboratoryReportApp.dataAccess.abstracts.ReportDao;
import com.project.LaboratoryReportApp.entities.concretes.Report;

@Service
public class ReportManager implements ReportService{

	private ReportDao reportDao;
	
	@Autowired
	public ReportManager(ReportDao reportDao) {
		super();
		this.reportDao = reportDao;
	}
	
	@Override
	public List<Report> getAll() {
		return reportDao.findAll();
	}

	@Override
	public Report getById(int reportId) {
		return reportDao.findById(reportId).get();
	}

	@Override
	public Report add(Report report) {
		return reportDao.save(report);
	}

	@Override
	public void delete(int reportId) {
		reportDao.deleteById(reportId);
	}

	@Override
	public Report update(Report report) {
		Report reportToUpdate = reportDao.getReferenceById(report.getReportId());
		reportToUpdate = report;
		return reportDao.save(reportToUpdate);
	}

}
