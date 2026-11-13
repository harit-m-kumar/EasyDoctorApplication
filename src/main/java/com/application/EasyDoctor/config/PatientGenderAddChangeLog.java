package com.application.EasyDoctor.config;

import java.util.Iterator;
import java.util.List;

import com.application.EasyDoctor.Repository.DoctorRepository;
import com.application.EasyDoctor.Repository.PatientRepository;
import com.application.EasyDoctor.enums.Gender;
import com.application.EasyDoctor.model.Doctor;
import com.application.EasyDoctor.model.Patient;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;

@ChangeUnit(order="002", id="patientGenderAdd1", author="Harit")
public class PatientGenderAddChangeLog {

	@Execution
	public void addGenderMaleToMissing(PatientRepository patientRepository) {
		List<Patient> patients = patientRepository.findAll();
		
		Iterator<Patient> patIterator = patients.iterator();
		while(patIterator.hasNext()) {
			Patient tempPatient = patIterator.next();
			if (tempPatient.getGender() == null) {
				tempPatient.setGender(Gender.MALE);
			}
		}
		patientRepository.saveAll(patients);
	}
	
	@RollbackExecution
	public void rollbackAddingGenderAsMale(PatientRepository patientRepository) {
		List<Patient> patients = patientRepository.findAll();
		
		Iterator<Patient> patIterator = patients.iterator();
		while(patIterator.hasNext()) {
			Patient tempPatient = patIterator.next();
			if (tempPatient.getGender() != null) {
				tempPatient.setGender(null);
			}
		}
		patientRepository.saveAll(patients);
	}
	
}
