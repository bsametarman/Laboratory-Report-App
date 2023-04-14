package com.project.LaboratoryReportApp.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.project.LaboratoryReportApp.business.abstracts.ImageService;
import com.project.LaboratoryReportApp.business.requests.CreateImageRequest;
import com.project.LaboratoryReportApp.business.responses.GetAllImagesResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdImageResponse;
import com.project.LaboratoryReportApp.core.utilities.mappers.ModelMapperService;
import com.project.LaboratoryReportApp.core.utilities.results.DataResult;
import com.project.LaboratoryReportApp.core.utilities.results.ErrorDataResult;
import com.project.LaboratoryReportApp.core.utilities.results.SuccessDataResult;
import com.project.LaboratoryReportApp.dataAccess.abstracts.ImageDao;
import com.project.LaboratoryReportApp.entities.concretes.Image;

@Service
public class ImageManager implements ImageService {
	
	private ImageDao imageDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ImageManager(ImageDao imageDao, ModelMapperService modelMapperService) {
		this.imageDao = imageDao;
		this.modelMapperService = modelMapperService;
	}
	
	@Override
	public DataResult<List<GetAllImagesResponse>> getAll() {
		try {
			List<Image> images = this.imageDao.findAll();
			List<GetAllImagesResponse> imageResponse = images.stream().map(image -> this.modelMapperService.forResponse().map(image, GetAllImagesResponse.class)).collect(Collectors.toList());
			
			return new SuccessDataResult<List<GetAllImagesResponse>>(imageResponse, "Successfully listed!");
		} catch (Exception e) {
			return new ErrorDataResult<List<GetAllImagesResponse>>(e.getMessage());
		}
		
	}

	@Override
	public DataResult<GetByIdImageResponse> getById(int id) {
		try {
			Image image = this.imageDao.findById(id).orElseThrow();
			GetByIdImageResponse imageResponse = this.modelMapperService.forResponse().map(image, GetByIdImageResponse.class);
			
			return new SuccessDataResult<GetByIdImageResponse>(imageResponse, "Successfully listed.");
		} catch (Exception e) {
			return new ErrorDataResult<GetByIdImageResponse>(e.getMessage());
		}
		
	}

	@Override
	public void add(MultipartFile image, int reportId) throws IOException {
		String imageName = StringUtils.cleanPath(image.getOriginalFilename());
	    Image imageToSave = new Image(imageName, image.getContentType(), image.getBytes());
	    CreateImageRequest imageRequest = this.modelMapperService.forRequest().map(imageToSave, CreateImageRequest.class);
	    imageRequest.setReportId(reportId);
	    imageToSave = this.modelMapperService.forRequest().map(imageRequest, Image.class);
	    this.imageDao.save(imageToSave);
	}

	@Override
	public void delete(int id) {
		this.imageDao.deleteById(id);
	}

}
