package com.application.EasyDoctor.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.application.EasyDoctor.Repository.PatientRepository;
import com.application.EasyDoctor.model.Patient;

@Service
public class PatientService {
	
	private static final Logger log = LoggerFactory.getLogger(PatientService.class);
	
	private final PatientRepository patientRepository;
	
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	public void addPatient(Patient patient) throws Exception{
		log.info("Inside PatientService.addPatient");
		Patient newPatient = new Patient();

		newPatient.setAddress(patient.getAddress());
		newPatient.setAge(patient.getAge());
		newPatient.setExistingConditions(patient.getExistingConditions());
		newPatient.setMobileNumber(patient.getMobileNumber());
		newPatient.setPatientCategory(patient.getPatientCategory());
		newPatient.setPatientName(patient.getPatientName());
		newPatient.setRegistrationDate(patient.getRegistrationDate());
		
		Patient savedPatient = this.patientRepository.save(newPatient);
		log.info("Patient generated with id : " + savedPatient.getPatientId());
	}
	
	public void updatePatient(Patient patient) throws Exception {
		log.info("Inside PatientService.updatePatient");
		Optional<Patient> updatedPatientOptional = this.patientRepository.findById(patient.getPatientId());
		if (updatedPatientOptional.isPresent()) {
			Patient updatedPatient = updatedPatientOptional.get();

			updatedPatient.setAddress(patient.getAddress());
			updatedPatient.setExistingConditions(patient.getExistingConditions());
			updatedPatient.setMobileNumber(patient.getMobileNumber());
			updatedPatient.setPatientCategory(patient.getPatientCategory());
			updatedPatient.setPatientName(patient.getPatientName());
			updatedPatient.setRegistrationDate(patient.getRegistrationDate());

			Patient newlyUpdatedPatient = this.patientRepository.save(updatedPatient);
			log.info("Patient with the given id has been updated : " + newlyUpdatedPatient.getPatientId());
		} else {
			log.info("Patient does not exist : " + patient.getPatientId());
			throw new Exception("Patient does not exist : " + patient.getPatientId());
		}
	}
	
	public List<Patient> getAllPatients() throws Exception{
		List<Patient> patientsList = this.patientRepository.findAll();
		return patientsList;
	}
	
	public Patient getPatientById(String patientid) {
		Optional<Patient> patient = this.patientRepository.findById(patientid);
		return patient.get();
	}
	
}
