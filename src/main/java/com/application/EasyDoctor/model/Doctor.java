package com.application.EasyDoctor.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document("doctor")
public class Doctor {

	@Id
	@Field(name = "doctor_id")
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
}
