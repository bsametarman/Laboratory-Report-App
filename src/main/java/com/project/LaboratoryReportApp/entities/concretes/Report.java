package com.project.LaboratoryReportApp.entities.concretes;

import java.util.Date;

import com.project.LaboratoryReportApp.entities.abstracts.IEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="reports")
@AllArgsConstructor
@NoArgsConstructor
public class Report implements IEntity{
	
	@Id
	@GeneratedValue
	@Column(name="report_id")
	private int reportId;
	
	@Column(name="file_no")
	private String fileNo;
	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="patient_surname")
	private String patientSurname;
	
	@Column(name="patient_identity_number")
	private String patientIdentityNumber;
	
	@Column(name="diagnostic_title")
	private String diagnosticTitle;
	
	@Column(name="diagnostic_detail")
	private String diagnosticDetail;
	
	@Column(name="report_date")
	private Date reportDate;
	
	@Column(name="image")
	private byte[] image;
}
