package com.project.LaboratoryReportApp.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateImageRequest {
	private int imageId;
	private String imageName;
	private String imageType;
	private byte[] imageData;
	private int reportId;
}
