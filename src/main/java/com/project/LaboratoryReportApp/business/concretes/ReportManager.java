package com.project.LaboratoryReportApp.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LaboratoryReportApp.business.abstracts.ReportService;
import com.project.LaboratoryReportApp.business.requests.CreateReportRequest;
import com.project.LaboratoryReportApp.business.requests.UpdateReportRequest;
import com.project.LaboratoryReportApp.business.responses.GetByPatientIdentityNumberReportResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsByPatientNameOrSurnameResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsReportDateAscResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsReportDateDescResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdReportResponse;
import com.project.LaboratoryReportApp.core.utilities.mappers.ModelMapperService;
import com.project.LaboratoryReportApp.dataAccess.abstracts.ReportDao;
import com.project.LaboratoryReportApp.entities.concretes.Report;

@Service
public class ReportManager implements ReportService{

	private ReportDao reportDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ReportManager(ReportDao reportDao, ModelMapperService modelMapperService) {
		this.reportDao = reportDao;
		this.modelMapperService = modelMapperService;
	}
	
	@Override
	public List<GetAllReportsResponse> getAll() {
		List<Report> reports = reportDao.findAll();
		List<GetAllReportsResponse> reportResponse = reports.stream().map(report -> this.modelMapperService.forResponse().map(report, GetAllReportsResponse.class)).collect(Collectors.toList());
		
		return reportResponse;
	}

	@Override
	public GetByIdReportResponse getById(int reportId) {
		Report report = this.reportDao.findById(reportId).orElseThrow();
		GetByIdReportResponse reportResponse = this.modelMapperService.forResponse().map(report, GetByIdReportResponse.class);
		return reportResponse;
	}

	@Override
	public CreateReportRequest add(CreateReportRequest reportRequest) {
		Report report = this.modelMapperService.forRequest().map(reportRequest, Report.class);
		this.reportDao.save(report);
		return reportRequest;
	}

	@Override
	public void delete(int reportId) {
		this.reportDao.deleteById(reportId);
	}

	@Override
	public UpdateReportRequest update(UpdateReportRequest reportRequest) {
		Report report = this.modelMapperService.forRequest().map(reportRequest, Report.class);
		this.reportDao.save(report);
		return reportRequest;
	}

	@Override
	public List<GetAllReportsByPatientNameOrSurnameResponse> getAllByPatientNameOrSurname(String patientName, String patientSurname) {
		List<Report> reports = this.reportDao.findAllByPatientNameIgnoreCaseOrPatientSurnameIgnoreCase(patientName, patientSurname);
		List<GetAllReportsByPatientNameOrSurnameResponse> reportResponse = reports.stream().map(report -> this.modelMapperService.forResponse().map(report, GetAllReportsByPatientNameOrSurnameResponse.class)).collect(Collectors.toList());
		return reportResponse;
	}

	@Override
	public List<GetByPatientIdentityNumberReportResponse> getAllByPatientIdentityNumber(String identityNumber) {
		List<Report> reports = this.reportDao.findAllByPatientIdentityNumberIgnoreCase(identityNumber);
		List<GetByPatientIdentityNumberReportResponse> reportResponse = reports.stream().map(report -> this.modelMapperService.forResponse().map(report, GetByPatientIdentityNumberReportResponse.class)).collect(Collectors.toList());
		return reportResponse;
	}

	@Override
	public List<GetAllReportsReportDateDescResponse> getAllReportDateDesc() {
		List<Report> reports = this.reportDao.findByOrderByReportDateDesc();
		List<GetAllReportsReportDateDescResponse> reportResponse = reports.stream().map(report -> this.modelMapperService.forResponse().map(report, GetAllReportsReportDateDescResponse.class)).collect(Collectors.toList());
		return reportResponse;
	}

	@Override
	public List<GetAllReportsReportDateAscResponse> getAllReportDateAsc() {
		List<Report> reports = this.reportDao.findByOrderByReportDateAsc();
		List<GetAllReportsReportDateAscResponse> reportResponse = reports.stream().map(report -> this.modelMapperService.forResponse().map(report, GetAllReportsReportDateAscResponse.class)).collect(Collectors.toList());
		return reportResponse;
	}

}
