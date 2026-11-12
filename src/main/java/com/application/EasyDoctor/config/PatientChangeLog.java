package com.application.EasyDoctor.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.application.EasyDoctor.Repository.DoctorRepository;
import com.application.EasyDoctor.Repository.PatientRepository;
import com.application.EasyDoctor.model.Doctor;
import com.application.EasyDoctor.model.Patient;
import com.application.EasyDoctor.model.PatientCategory;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;

@ChangeUnit(order="002", id="patientsAdding1", author="Harit")
public class PatientChangeLog {

	private Patient createPatient(String patientName, String mobileNumber, int age, String address,
			List<String> existingConditions, PatientCategory patientCategory, Date registrationDate){
		Patient patient = new Patient();
		patient.setPatientName(patientName);
		patient.setMobileNumber(mobileNumber);
		patient.setAge(age);
		patient.setAddress(address);
		patient.setExistingConditions(existingConditions);
		patient.setPatientCategory(patientCategory);
		patient.setRegistrationDate(registrationDate);
		return patient;
	}

	@Execution
	public void addPatients(PatientRepository patientRepository) {
		List<Patient> patientsList = new ArrayList<>();
		patientsList.add(this.createPatient("Damodaran Unni", "9766578856", 78, 
				"Raroth Kandi, Balussery West, Kozhikode", new ArrayList<>(List.of("Leg Ache", "Low vision", "back pain")),
				PatientCategory.SENIOR_CITIZEN, new Date(2025, 10, 12)));
		patientsList.add(this.createPatient("Mannarathody Jaykrishnan", "9667534456", 60, 
				"Mannarathody, Pull, Thrissur", new ArrayList<>(List.of("Piles", "Fistula", "Memory Loss")),
				PatientCategory.SENIOR_CITIZEN, new Date(2021, 04, 12)));
		patientsList.add(this.createPatient("Ramanan", "9665434456", 35, 
				"Boat 56, Jetty, Ernakulam", new ArrayList<>(List.of("Low weight", "Body Pain", "Confusion")),
				PatientCategory.SENIOR_CITIZEN, new Date(2023, 04, 12)));
		patientsList.add(this.createPatient("Vaduthala Valsala", "9887456672", 31, 
				"69-C Palayalam, Ernakulam", new ArrayList<>(List.of("High Libido", "Gonnorhea")),
				PatientCategory.SENIOR_CITIZEN, new Date(2025, 04, 25)));
		patientRepository.insert(patientsList);
	}
	
	@RollbackExecution
	public void rollbackAddPatients(DoctorRepository doctorRepository) {
		// Reverts the migration if execution fails mid-way
		/*
		 * List<Integer> registrationIds = List.of(356112, 561284, 761290);
		 * doctorRepository.findAll().stream() .filter(doc ->
		 * registrationIds.contains(doc.getRegistrationId()))
		 * .forEach(doctorRepository::delete);
		 */
	}
	
}
