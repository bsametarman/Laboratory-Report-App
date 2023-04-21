package com.project.LaboratoryReportApp.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LaboratoryReportApp.entities.concretes.Laborant;

public interface LaborantDao extends JpaRepository<Laborant, Integer>{
	List<Laborant> findAllByLaborantNameIgnoreCaseOrLaborantSurnameIgnoreCase(String name, String surname);
	List<Laborant> findAllByHospitalIdentityNumberIgnoreCase(String hospitalIdentityNumber);
	List<Laborant> findAllByLaborantIdentityNumberIgnoreCase(String laborantIdentityNumber);
	List<Laborant> findAllByIsActive(boolean isActive);
	boolean existsByLaborantNameIgnoreCaseAndLaborantSurnameIgnoreCase(String name, String surname);
	boolean existsByLaborantIdentityNumber(String identityNumber);
}
