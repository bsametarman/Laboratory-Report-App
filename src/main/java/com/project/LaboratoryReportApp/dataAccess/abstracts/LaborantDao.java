package com.project.LaboratoryReportApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LaboratoryReportApp.entities.concretes.Laborant;

public interface LaborantDao extends JpaRepository<Laborant, Integer>{

}
