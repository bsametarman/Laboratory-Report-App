package com.project.LaboratoryReportApp.entities.concretes;

import java.util.List;

import com.project.LaboratoryReportApp.entities.abstracts.IEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="laborants")
@AllArgsConstructor
@NoArgsConstructor
public class Laborant implements IEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="laborant_id")
	private int laborantId;
	
	@Column(name="laborant_name")
	private String laborantName;
	
	@Column(name="laborant_surname")
	private String laborantSurname;
	
	@Column(name="laborant_identity_number")
	private String laborantIdentityNumber;
	
	@Column(name="hospital_identity_number")
	private String hospitalIdentityNumber;
	
	@OneToMany(mappedBy="laborant")
	private List<Report> reports;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
}
