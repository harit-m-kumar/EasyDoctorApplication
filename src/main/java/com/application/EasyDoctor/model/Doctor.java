package com.application.EasyDoctor.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("doctor")
public class Doctor {

	@Id
	private String doctorId;
	
	@Field(name = "doctor_name")
	private String doctorName;
	
	@Field(name = "address")
	private String doctorAddress;
	
	@Field(name = "contact_number")
	private String contactNumber;
	
	@Field(name = "qualifications_by_year")
	private Map<String, String> qualificationsByYear;
	
	@Field(name = "registration_id")
	private Integer registrationId;
	
	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Map<String, String> getQualificationsByYear() {
		return qualificationsByYear;
	}

	public void setQualificationsByYear(Map<String, String> qualificationsByYear) {
		this.qualificationsByYear = qualificationsByYear;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}
	
}
