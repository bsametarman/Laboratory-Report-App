package com.project.LaboratoryReportApp.entities.concretes;

import com.project.LaboratoryReportApp.entities.abstracts.IEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="images")
@AllArgsConstructor
@NoArgsConstructor
public class Image implements IEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="image_id")
	private int imageId;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="image_type")
	private String imageType;
	
	@Column(name="image_data")
	private byte[] imageData;
	
	@ManyToOne
	@JoinColumn(name="report_id")
	private Report report;
	
	public Image(String imageName, String imageType, byte[] imageData) {
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageData = imageData;
	}
}
