package com.project.LaboratoryReportApp.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LaboratoryReportApp.business.abstracts.ReportService;
import com.project.LaboratoryReportApp.business.requests.CreateReportRequest;
import com.project.LaboratoryReportApp.business.requests.UpdateReportRequest;
import com.project.LaboratoryReportApp.business.responses.GetAllActiveReportsResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsByPatientNameOrSurnameResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsReportDateAscResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsReportDateDescResponse;
import com.project.LaboratoryReportApp.business.responses.GetAllReportsResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdReportResponse;
import com.project.LaboratoryReportApp.business.responses.GetByPatientIdentityNumberReportResponse;
import com.project.LaboratoryReportApp.business.rules.ReportBusinessRules;
import com.project.LaboratoryReportApp.business.rules.ReportValidationRules;
import com.project.LaboratoryReportApp.core.utilities.mappers.ModelMapperService;
import com.project.LaboratoryReportApp.core.utilities.results.DataResult;
import com.project.LaboratoryReportApp.core.utilities.results.ErrorDataResult;
import com.project.LaboratoryReportApp.core.utilities.results.SuccessDataResult;
import com.project.LaboratoryReportApp.dataAccess.abstracts.ReportDao;
import com.project.LaboratoryReportApp.entities.concretes.Report;

@Service
public class ReportManager implements ReportService{

	private ReportDao reportDao;
	private ModelMapperService modelMapperService;
	private ReportBusinessRules reportBusinessRules;
	private ReportValidationRules reportValidationRules;
	
	@Autowired
	public ReportManager(ReportDao reportDao, ModelMapperService modelMapperService,
			ReportBusinessRules reportBusinessRules, ReportValidationRules reportValidationRules) {
		this.reportDao = reportDao;
		this.modelMapperService = modelMapperService;
		this.reportBusinessRules = reportBusinessRules;
		this.reportValidationRules = reportValidationRules;
	}
	
	@Override
	public DataResult<List<GetAllReportsResponse>> getAll() {
		try {
			List<Report> reports = reportDao.findAll();
			List<GetAllReportsResponse> reportResponse = reports.stream().map(report -> this.modelMapperService.forResponse().map(report, GetAllReportsResponse.class)).collect(Collectors.toList());
			
			return new SuccessDataResult<List<GetAllReportsResponse>>(reportResponse, "Successfully listed!");
		} catch (Exception e) {
			return new ErrorDataResult<List<GetAllReportsResponse>>(e.getMessage());
		}
		
	}

	@Override
	public DataResult<GetByIdReportResponse> getById(int reportId) {
		try {
			Report report = this.reportDao.findById(reportId).orElseThrow();
			GetByIdReportResponse reportResponse = this.modelMapperService.forResponse().map(report, GetByIdReportResponse.class);
			
			return new SuccessDataResult<GetByIdReportResponse>(reportResponse, "Successfully listed!");
		} catch (Exception e) {
			return new ErrorDataResult<GetByIdReportResponse>(e.getMessage());
		}
		
	}

	@Override
	public DataResult<CreateReportRequest> add(CreateReportRequest reportRequest) {
		Report report = this.modelMapperService.forRequest().map(reportRequest, Report.class);
		
		this.reportValidationRules.checkIfFileNoIsValid(report.getFileNo());
		this.reportValidationRules.checkIfPatientNameIsValid(report.getPatientName());
		this.reportValidationRules.checkIfPatientSurnameIsValid(report.getPatientSurname());
		this.reportValidationRules.checkIfPatientIdentityNumberIsValid(report.getPatientIdentityNumber());
		this.reportValidationRules.checkIfDiagnosticTitleIsValid(report.getDiagnosticTitle());
		this.reportValidationRules.checkIfDiagnosticDetailIsValid(report.getDiagnosticDetail());
		
		this.reportBusinessRules.checkIfFileNoExists(report.getFileNo());
		
		report.setActive(true);
		
		Report savedReport = this.reportDao.save(report);
		
		CreateReportRequest savedReportRequest = this.modelMapperService.forRequest().map(savedReport, CreateReportRequest.class);
		
		return new SuccessDataResult<CreateReportRequest>(savedReportRequest, "Successfully added!");
		
	}

	@Override
	public void delete(int reportId) {
		this.reportDao.deleteById(reportId);
	}

	@Override
	public DataResult<UpdateReportRequest> update(UpdateReportRequest reportRequest) {
		try {
			Report report = this.modelMapperService.forRequest().map(reportRequest, Report.class);
			report.setActive(true);
			this.reportDao.save(report);
			
			return new SuccessDataResult<UpdateReportRequest>(reportRequest, "Successfully updated!");
		} catch (Exception e) {
			return new ErrorDataResult<UpdateReportRequest>(e.getMessage());
		}
		
	}

	@Override
	public DataResult<List<GetAllReportsByPatientNameOrSurnameResponse>> getAllByPatientNameOrSurname(String patientName, String patientSurname) {
		try {
			List<Report> reports = this.reportDao.findAllByPatientNameIgnoreCaseOrPatientSurnameIgnoreCase(patientName, patientSurname);
			List<GetAllReportsByPatientNameOrSurnameResponse> reportResponse = reports.stream().map(report -> this.modelMapperService.forResponse().map(report, GetAllReportsByPatientNameOrSurnameResponse.class)).collect(Collectors.toList());
			
			return new SuccessDataResult<List<GetAllReportsByPatientNameOrSurnameResponse>>(reportResponse, "Successfully listed!");
		} catch (Exception e) {
			return new ErrorDataResult<List<GetAllReportsByPatientNameOrSurnameResponse>>(e.getMessage());
		}
	}

	@Override
	public DataResult<List<GetByPatientIdentityNumberReportResponse>> getAllByPatientIdentityNumber(String identityNumber) {
		try {
			List<Report> reports = this.reportDao.findAllByPatientIdentityNumberIgnoreCase(identityNumber);
			List<GetByPatientIdentityNumberReportResponse> reportResponse = reports.stream().map(report -> this.modelMapperService.forResponse().map(report, GetByPatientIdentityNumberReportResponse.class)).collect(Collectors.toList());
			
			return new SuccessDataResult<List<GetByPatientIdentityNumberReportResponse>>(reportResponse, "Successfully listed!");
		} catch (Exception e) {
			return new ErrorDataResult<List<GetByPatientIdentityNumberReportResponse>>(e.getMessage());
		}
		
	}

	@Override
	public DataResult<List<GetAllReportsReportDateDescResponse>> getAllReportDateDesc() {
		try {
			List<Report> reports = this.reportDao.findByOrderByReportDateDesc();
			List<GetAllReportsReportDateDescResponse> reportResponse = reports.stream().map(report -> this.modelMapperService.forResponse().map(report, GetAllReportsReportDateDescResponse.class)).collect(Collectors.toList());
			
			return new SuccessDataResult<List<GetAllReportsReportDateDescResponse>>(reportResponse, "Successfully listed!");
		} catch (Exception e) {
			return new ErrorDataResult<List<GetAllReportsReportDateDescResponse>>(e.getMessage());
		}
	}

	@Override
	public DataResult<List<GetAllReportsReportDateAscResponse>> getAllReportDateAsc() {
		try {
			List<Report> reports = this.reportDao.findByOrderByReportDateAsc();
			List<GetAllReportsReportDateAscResponse> reportResponse = reports.stream().map(report -> this.modelMapperService.forResponse().map(report, GetAllReportsReportDateAscResponse.class)).collect(Collectors.toList());
			
			return new SuccessDataResult<List<GetAllReportsReportDateAscResponse>>(reportResponse, "Successfully listed!");
		} catch (Exception e) {
			return new ErrorDataResult<List<GetAllReportsReportDateAscResponse>>(e.getMessage());
		}
		
	}
	
	@Override
	public DataResult<List<GetAllReportsReportDateDescResponse>> getAllActiveReportsDateDesc() {
		try {
			List<Report> reports = this.reportDao.findAllByIsActiveOrderByReportDateDesc(true);
			List<GetAllReportsReportDateDescResponse> reportResponse = reports.stream().map(report -> this.modelMapperService.forResponse().map(report, GetAllReportsReportDateDescResponse.class)).collect(Collectors.toList());
			
			return new SuccessDataResult<List<GetAllReportsReportDateDescResponse>>(reportResponse, "Successfully listed!");
		} catch (Exception e) {
			return new ErrorDataResult<List<GetAllReportsReportDateDescResponse>>(e.getMessage());
		}
	}

	@Override
	public DataResult<List<GetAllReportsReportDateAscResponse>> getAllActiveReportsDateAsc() {
		try {
			List<Report> reports = this.reportDao.findAllByIsActiveOrderByReportDateAsc(true);
			List<GetAllReportsReportDateAscResponse> reportResponse = reports.stream().map(report -> this.modelMapperService.forResponse().map(report, GetAllReportsReportDateAscResponse.class)).collect(Collectors.toList());
			
			return new SuccessDataResult<List<GetAllReportsReportDateAscResponse>>(reportResponse, "Successfully listed!");
		} catch (Exception e) {
			return new ErrorDataResult<List<GetAllReportsReportDateAscResponse>>(e.getMessage());
		}
		
	}

	@Override
	public DataResult<List<GetAllActiveReportsResponse>> getAllActiveReports() {
		try {
			List<Report> reports = reportDao.findAllByIsActive(true);
			List<GetAllActiveReportsResponse> reportResponse = reports.stream().map(report -> this.modelMapperService.forResponse().map(report, GetAllActiveReportsResponse.class)).collect(Collectors.toList());
			
			return new SuccessDataResult<List<GetAllActiveReportsResponse>>(reportResponse, "Successfully listed!");
		} catch (Exception e) {
			return new ErrorDataResult<List<GetAllActiveReportsResponse>>(e.getMessage());
		}
	}

	@Override
	public void changeActiveState(int reportId) {
		try {
			Report report = this.reportDao.findById(reportId).orElseThrow();
			boolean activeState = report.isActive() == true ? false : true;
			report.setActive(activeState);
			this.reportDao.save(report);
			
		} catch (Exception e) {
			
		}
	}

}
