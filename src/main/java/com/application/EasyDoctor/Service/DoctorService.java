package com.application.EasyDoctor.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.application.EasyDoctor.Repository.DoctorRepository;
import com.application.EasyDoctor.model.Doctor;

@Service
public class DoctorService {

	private static final Logger log = LoggerFactory.getLogger(DoctorService.class);
	
	public final DoctorRepository doctorRepository;
	
	public DoctorService(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	
	public void addDoctor(Doctor doctor) {
		log.info("Inside DoctorService.addDoctor");
		Doctor newDoctor = new Doctor();
		
		newDoctor.setDoctorAddress(doctor.getDoctorAddress());
		newDoctor.setDoctorName(doctor.getDoctorName());
		newDoctor.setContactNumber(doctor.getContactNumber());
		newDoctor.setQualificationsByYear(doctor.getQualificationsByYear());
		newDoctor.setRegistrationId(doctor.getRegistrationId());
		
		Doctor addedDoctor = this.doctorRepository.save(newDoctor);
		log.info("New Doctor added successfully with Doctor Id : {}", addedDoctor.getDoctorId());
	}
	
	public Doctor getDoctorById(String doctorId) throws Exception {
		log.info("Inside DoctorService.getDoctorById");
		Optional<Doctor> doctor = this.doctorRepository.findById(doctorId);
		if (doctor.isPresent()) {
			return doctor.get();
		} else {
			throw new Exception("Doctor with the given id does not exist : " + doctorId);
		}
	}
	
	public void updateDoctor(Doctor doctor) throws Exception {
		log.info("Inside DoctorService.updateDoctor");
		Optional<Doctor> fetchedDoctorOptional = this.doctorRepository.findById(doctor.getDoctorId());
		if (fetchedDoctorOptional.isPresent()) {
			Doctor fetchedDoctor = fetchedDoctorOptional.get();
			
			fetchedDoctor.setContactNumber(doctor.getContactNumber());
			fetchedDoctor.setDoctorAddress(doctor.getDoctorAddress());
			fetchedDoctor.setDoctorName(doctor.getDoctorName());
			fetchedDoctor.setQualificationsByYear(doctor.getQualificationsByYear());
			fetchedDoctor.setRegistrationId(doctor.getRegistrationId());
			
			this.doctorRepository.save(fetchedDoctor);
			log.info("Doctor with the given id has been updated : " + fetchedDoctor.getDoctorId());
		} else {
			log.info("Searched doctor does not exist with id : {}", doctor.getDoctorId());
			throw new Exception("Searched doctor does not exist with id : " + doctor.getDoctorId());
		}
	}
	
	public List<Doctor> getAllDoctors() {
		log.info("Inside DoctorService.updateDoctor");
		List<Doctor> doctorsList = this.doctorRepository.findAll();
		return doctorsList;
	}
	
}
