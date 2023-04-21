package com.project.LaboratoryReportApp.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LaboratoryReportApp.entities.concretes.Report;

public interface ReportDao extends JpaRepository<Report, Integer>{
	List<Report> findAllByPatientNameIgnoreCaseOrPatientSurnameIgnoreCase(String patientName, String patientSurname);
	List<Report> findAllByPatientIdentityNumberIgnoreCase(String patientIdentityNumber);
	List<Report> findByOrderByReportDateDesc();
	List<Report> findByOrderByReportDateAsc();
	List<Report> findAllByIsActive(boolean isActive);
	//List<Report> findAllByLaborantNameIgnoreCaseOrLaborantSurnameIgnoreCase(String laborantName, String laborantSurname);
	boolean existsByFileNo(String fileNo);
}
