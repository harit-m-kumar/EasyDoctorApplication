package com.application.EasyDoctor.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.application.EasyDoctor.Repository.DoctorRepository;
import com.application.EasyDoctor.model.Doctor;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;

@ChangeUnit(order="001", id="doctorsAdding4", author="Harit")
public class DatabaseChangeLog {
	
	private Doctor createDoctor(String doctorName, String doctorAddress, String contactNumber, 
			Map<String, String> qualificationsByYear, Integer registrationId){
		Doctor doctor = new Doctor(doctorName, doctorAddress, contactNumber, qualificationsByYear, registrationId);
		return doctor;
	}

	@Execution
	public void addDoctors(DoctorRepository doctorRepository) {
		List<Doctor> docsList = new ArrayList<>();
		docsList.add(this.createDoctor("Arshad Shafi", "32-A, DL Street,Kundara, Kollam", "9263789844", 
				new HashMap<>(Map.of(
					    "2011", "MBBS",
					    "2018", "DNB"
					)), 
				Integer.valueOf("356112")));
		docsList.add(this.createDoctor("Catelyna Dsouza", "26-B, Fort Kochi, Ernakulam", "9565719531", 
				new HashMap<>(Map.of(
					    "2012", "MBBS",
					    "2018", "MD - Gynecology"
					)), 
				Integer.valueOf("561284")));
		docsList.add(this.createDoctor("Henna Afsana", "3-D, Skyline, South Beach, Kozhikode", "9761719282", 
				new HashMap<>(Map.of(
					    "2010", "MBBS",
					    "2018", "MD - Paedetarics"
					)), 
				Integer.valueOf("761290")));
		doctorRepository.insert(docsList);
	}
	
	@RollbackExecution
	public void rollbackAddDoctors(DoctorRepository doctorRepository) {
		// Reverts the migration if execution fails mid-way
		/*
		 * List<Integer> registrationIds = List.of(356112, 561284, 761290);
		 * doctorRepository.findAll().stream() .filter(doc ->
		 * registrationIds.contains(doc.getRegistrationId()))
		 * .forEach(doctorRepository::delete);
		 */
	}
	
}
