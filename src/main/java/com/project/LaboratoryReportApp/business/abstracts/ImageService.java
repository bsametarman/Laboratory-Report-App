package com.project.LaboratoryReportApp.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.LaboratoryReportApp.business.responses.GetAllImagesResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdImageResponse;

public interface ImageService {
	List<GetAllImagesResponse> getAll();
	GetByIdImageResponse getById(int id);
	void add(MultipartFile image, int reportId) throws IOException;
	void delete(int id);
}
