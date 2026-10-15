package com.application.EasyDoctor.model;

import java.util.Date;
import java.util.List;

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
@Document("visit")
public class Visit {
	
	@Id
	private String visitId;
	
	@Field(name = "patient_id")
	private String patientId;
	
	@Field(name = "consulted_doctor_id")
	private String consultedDoctorId;
	
	@Field(name = "date_of_visit")
	private Date dateAndTimeOfVisit;
	
	@Field(name = "symptoms")
	private List<String> symptoms;
	
	@Field(name = "diagnosis")
	private List<String> diagnosis;
	
	@Field(name = "follow_up_date")
	private List<String> followUpDate;

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getConsultedDoctorId() {
		return consultedDoctorId;
	}

	public void setConsultedDoctorId(String consultedDoctorId) {
		this.consultedDoctorId = consultedDoctorId;
	}

	public Date getDateAndTimeOfVisit() {
		return dateAndTimeOfVisit;
	}

	public void setDateAndTimeOfVisit(Date dateAndTimeOfVisit) {
		this.dateAndTimeOfVisit = dateAndTimeOfVisit;
	}

	public List<String> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<String> symptoms) {
		this.symptoms = symptoms;
	}

	public List<String> getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(List<String> diagnosis) {
		this.diagnosis = diagnosis;
	}

	public List<String> getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(List<String> followUpDate) {
		this.followUpDate = followUpDate;
	}
	
}
