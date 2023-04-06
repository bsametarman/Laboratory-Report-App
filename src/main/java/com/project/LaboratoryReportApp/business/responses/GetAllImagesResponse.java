package com.project.LaboratoryReportApp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllImagesResponse {
	private int id;
	private String imageName;
	private String imageType;
	private byte[] imageData;
}
