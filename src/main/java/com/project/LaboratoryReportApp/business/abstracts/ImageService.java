package com.project.LaboratoryReportApp.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.LaboratoryReportApp.business.responses.GetAllImagesResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdImageResponse;
import com.project.LaboratoryReportApp.entities.concretes.Image;

public interface ImageService {
	List<GetAllImagesResponse> getAll();
	GetByIdImageResponse getById(int id);
	Image add(MultipartFile image, int reportId) throws IOException;
	void delete(int id);
}
