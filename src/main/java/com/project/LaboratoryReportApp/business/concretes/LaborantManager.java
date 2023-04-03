package com.project.LaboratoryReportApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LaboratoryReportApp.business.abstracts.LaborantService;
import com.project.LaboratoryReportApp.dataAccess.abstracts.LaborantDao;
import com.project.LaboratoryReportApp.entities.concretes.Laborant;

@Service
public class LaborantManager implements LaborantService{
	
	private LaborantDao laborantDao;
	
	@Autowired
	public LaborantManager(LaborantDao laborantDao) {
		super();
		this.laborantDao = laborantDao;
	}
	
	@Override
	public List<Laborant> getAll() {
		return laborantDao.findAll();
	}

	@Override
	public Laborant getById(int laborantId) {
		return laborantDao.findById(laborantId).get();
	}

	@Override
	public Laborant add(Laborant laborant) {
		return laborantDao.save(laborant);
	}

	@Override
	public void delete(int laborantId) {
		laborantDao.deleteById(laborantId);
	}

	@Override
	public Laborant update(Laborant laborant) {
		Laborant updatedEntity = laborantDao.getReferenceById(laborant.getLaborantId());
		updatedEntity = laborant;
		return laborantDao.save(updatedEntity);
	}

}
