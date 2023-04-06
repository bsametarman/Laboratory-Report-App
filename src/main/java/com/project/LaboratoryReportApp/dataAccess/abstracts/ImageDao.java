package com.project.LaboratoryReportApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LaboratoryReportApp.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{

}
