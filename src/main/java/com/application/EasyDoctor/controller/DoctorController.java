package com.application.EasyDoctor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.EasyDoctor.Repository.DoctorRepository;
import com.application.EasyDoctor.Service.DoctorService;
import com.application.EasyDoctor.model.Doctor;

import lombok.extern.slf4j.Slf4j;

/*
 * Controller class for API operations on Patient repository
 * @Author : Harit M
 * @Date : 10/10/2026
 * 1. addDoctor
 * 2. getDoctorById
 * 3. updateDoctor
 * 4. listAllDoctors
 * 5. deleteDoctor
 */
@RestController
@RequestMapping("/doctor")
@Slf4j
public class DoctorController {

	private static final Logger log = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	DoctorService doctorService;
	
	@PostMapping("/addDoctor")
	public ResponseEntity<WebEndpointResponse> addDoctor(@RequestBody Doctor doctor) {
		WebEndpointResponse addDocEndpointResponse = null;
		try {
			this.doctorService.addDoctor(doctor);
			addDocEndpointResponse = new WebEndpointResponse<>("Doctor added successfully", WebEndpointResponse.STATUS_OK);
		} catch(Exception e) {
			log.info("Exception in Doctorcontroller.addDoctor : {}", e.getMessage());
			addDocEndpointResponse = new WebEndpointResponse(e.getMessage(), addDocEndpointResponse.STATUS_INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(addDocEndpointResponse.getStatus()).body(addDocEndpointResponse);
	}
	
	@GetMapping("/getDoctorById")
	public ResponseEntity<WebEndpointResponse> getDoctorById(@RequestParam String doctorId) {
		WebEndpointResponse getDoctorResponse = null;
		try {
			Doctor doctor = this.doctorService.getDoctorById(doctorId);
			getDoctorResponse = new WebEndpointResponse<>(doctor, WebEndpointResponse.STATUS_OK);
		} catch(Exception e) {
			log.info("Exception in Doctorcontroller.getDoctorById : {}", e.getMessage());
			getDoctorResponse = new WebEndpointResponse<>(e.getMessage(), getDoctorResponse.STATUS_INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(getDoctorResponse.getStatus()).body(getDoctorResponse);
	}
	
	@PutMapping("/updateDoctor")
	public ResponseEntity<WebEndpointResponse> updateDoctor(@RequestBody Doctor doctor) {
		WebEndpointResponse updateDoctorResponse = null;
		try {
			this.doctorService.updateDoctor(doctor);
			updateDoctorResponse = new WebEndpointResponse("Doctor details updated successfully", WebEndpointResponse.STATUS_OK);
		} catch(Exception e) {
			log.info("Exception in Doctorcontroller.updateDoctor : {}", e.getMessage());
			updateDoctorResponse = new WebEndpointResponse<>(e.getMessage(), updateDoctorResponse.STATUS_INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(updateDoctorResponse.getStatus()).body(updateDoctorResponse);
	}

	@GetMapping("listAllDoctors")
	public ResponseEntity<WebEndpointResponse> getAllDoctors() {
		WebEndpointResponse getAllDoctorsResponse = null;
		try {
			List<Doctor> doctorsList = this.doctorService.getAllDoctors();
			getAllDoctorsResponse = new WebEndpointResponse(doctorsList, WebEndpointResponse.STATUS_OK);
		} catch(Exception e) {
			log.info("Exception in Doctorcontroller.getAllDoctors : {}", e.getMessage());
			getAllDoctorsResponse = new WebEndpointResponse<>(e.getMessage(),
					WebEndpointResponse.STATUS_INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(getAllDoctorsResponse.getStatus()).body(getAllDoctorsResponse);
	}
	
	@DeleteMapping("/deleteDoctorById")
	public ResponseEntity<WebEndpointResponse> deleteDoctorById(@RequestParam String doctorId) {
		WebEndpointResponse deleteDoctorResponse = null;
		try {
			this.doctorService.deleteDoctor(doctorId);
			deleteDoctorResponse = new WebEndpointResponse<>("Doctor deleted successfully", WebEndpointResponse.STATUS_OK);
		} catch(Exception e) {
			log.info("Exception in Doctorcontroller.deleteEDoctorById : {}", e.getMessage());
			deleteDoctorResponse = new WebEndpointResponse<>(e.getMessage(), 
					WebEndpointResponse.STATUS_INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(deleteDoctorResponse.getStatus()).body(deleteDoctorResponse);
	}
	
}
