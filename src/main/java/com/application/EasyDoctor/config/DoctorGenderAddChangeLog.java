package com.application.EasyDoctor.config;

import java.util.Iterator;
import java.util.List;

import com.application.EasyDoctor.Repository.DoctorRepository;
import com.application.EasyDoctor.enums.Gender;
import com.application.EasyDoctor.model.Doctor;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;

@ChangeUnit(order="003", id="doctorsGenderUpdate1", author="Harit")
public class DoctorGenderAddChangeLog {

	@Execution
	public void addGenderMaleToMissing(DoctorRepository doctorRepository) {
		List<Doctor> doctors = doctorRepository.findAll();
		
		Iterator<Doctor> docIterator = doctors.iterator();
		while(docIterator.hasNext()) {
			Doctor tempDoctor = docIterator.next();
			if (tempDoctor.getGender() == null) {
				tempDoctor.setGender(Gender.MALE);
			}
		}
		doctorRepository.saveAll(doctors);
	}
	
	@RollbackExecution
	public void rollbackAddingGenderAsMale(DoctorRepository doctorRepository) {
		List<Doctor> doctors = doctorRepository.findAll();
		
		Iterator<Doctor> docIterator = doctors.iterator();
		while(docIterator.hasNext()) {
			Doctor tempDoctor = docIterator.next();
			if (tempDoctor.getGender() != null) {
				tempDoctor.setGender(null);
			}
		}
		doctorRepository.saveAll(doctors);
	}
	
}
