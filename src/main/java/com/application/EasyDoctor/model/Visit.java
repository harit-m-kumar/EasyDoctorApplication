package com.application.EasyDoctor.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document("visit")
public class Visit {

	@Id
	@Field(name = "visit_id")
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
	
}
