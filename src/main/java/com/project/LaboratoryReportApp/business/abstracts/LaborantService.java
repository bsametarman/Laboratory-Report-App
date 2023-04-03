package com.project.LaboratoryReportApp.business.abstracts;

import java.util.List;

import com.project.LaboratoryReportApp.entities.concretes.Laborant;

public interface LaborantService {
	public List<Laborant> getAll();
	public Laborant getById(int laborantId);
	public Laborant add(Laborant laborant);
	public void delete(int laborantId);
	public Laborant update(Laborant laborant);
}
