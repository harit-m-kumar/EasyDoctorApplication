package com.application.EasyDoctor.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Document("patient")
public class Patient {

	@Id
	private String patientId;
	
	@Indexed(unique = true)
	@Field(name = "patient_name")
	private String patientName;
	
	@Field(name = "mobile_number")
	private String mobileNumber;
	
	@Field(name = "age")
	private int age;
	
	@Field(name = "address")
	private String address;
	
	@Field(name = "existing_conditions")
	private List<String> existingConditions;
	
	@Field(name = "patient_category")
	private PatientCategory patientCategory;
	
	@Field(name = "registration_date")
	private Date registrationDate;
	
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getExistingConditions() {
		return existingConditions;
	}

	public void setExistingConditions(List<String> existingConditions) {
		this.existingConditions = existingConditions;
	}

	public PatientCategory getPatientCategory() {
		return patientCategory;
	}

	public void setPatientCategory(PatientCategory patientCategory) {
		this.patientCategory = patientCategory;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

}
