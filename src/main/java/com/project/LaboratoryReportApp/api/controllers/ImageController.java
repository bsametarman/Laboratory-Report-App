package com.project.LaboratoryReportApp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.LaboratoryReportApp.business.abstracts.ImageService;
import com.project.LaboratoryReportApp.business.responses.GetAllImagesResponse;
import com.project.LaboratoryReportApp.business.responses.GetByIdImageResponse;
import com.project.LaboratoryReportApp.core.utilities.results.DataResult;
import com.project.LaboratoryReportApp.core.utilities.results.SuccessDataResult;

@CrossOrigin
@RestController
@RequestMapping("/api/images")
public class ImageController {
	
	private ImageService imageService;
	
	@Autowired
	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllImagesResponse>> getAll(){
		return this.imageService.getAll();
	}
	
	@GetMapping("/getById/{image_id}")
	public DataResult<GetByIdImageResponse> getById(@PathVariable("image_id") int id) {
		return this.imageService.getById(id);
	}
	
	@PostMapping(value= "/add/{report_id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public DataResult<String> add(@RequestBody MultipartFile image, @PathVariable("report_id") int reportId) {
	    try {
    		this.imageService.add(image, reportId);
	    } 
	    catch (Exception e) {
	    }
	    
	    return new SuccessDataResult<String>(StringUtils.cleanPath(image.getOriginalFilename()), " başarıyla eklendi.");
	}
	
	@PostMapping("/delete/{image_id}")
	public void delete(@PathVariable("image_id") int id) {
		this.imageService.delete(id);
	}
}
