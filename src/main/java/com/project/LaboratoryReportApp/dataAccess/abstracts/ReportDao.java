package com.project.LaboratoryReportApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LaboratoryReportApp.entities.concretes.Report;

public interface ReportDao extends JpaRepository<Report, Integer>{

}
