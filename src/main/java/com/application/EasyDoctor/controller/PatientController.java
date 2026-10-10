package com.application.EasyDoctor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.EasyDoctor.Service.PatientService;
import com.application.EasyDoctor.model.Patient;

import lombok.extern.slf4j.Slf4j;

/*
 * Controller class for API operations on Patient repository
 * @Author : Harit M
 * @Date : 10/10/2026
 * 1. addPatient
 * 2. getPatientById
 * 3. updatePatient
 * 4. deletePatient
 */
@RestController
@RequestMapping("/patient")
@Slf4j
public class PatientController {
	
	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	PatientService patientService;

	@PostMapping("/addPatient")
	public ResponseEntity<WebEndpointResponse> addPatient(@RequestBody Patient patient) {
		WebEndpointResponse addPatientResposne = null;
		try {
			patientService.addPatient(patient);
			addPatientResposne = new WebEndpointResponse<>("Patient added successfully", 
					WebEndpointResponse.STATUS_OK);
		} catch(Exception e) {
			log.info("Excpetion in PatientController : {}", e.getMessage());
			addPatientResposne = new WebEndpointResponse<>(e.getMessage(), 
					WebEndpointResponse.STATUS_INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(addPatientResposne.getStatus()).body(addPatientResposne);
	}
	
	@GetMapping("/getPatientById")
	public ResponseEntity<WebEndpointResponse> getPatientById(@RequestParam String patientid) {
		WebEndpointResponse getPatientResposne = null;
		try {
			Patient currentPatient = patientService.getPatientById(patientid);
			getPatientResposne = new WebEndpointResponse<>(currentPatient, 
					WebEndpointResponse.STATUS_OK);
			//return ResponseEntity.ok(addPatientResposne);
		} catch(Exception e) {
			log.info("Excpetion in PatientController : {}", e.getMessage());
			getPatientResposne = new WebEndpointResponse<>(e.getMessage(), 
					WebEndpointResponse.STATUS_INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(getPatientResposne.getStatus()).body(getPatientResposne);
	}
	
	@PutMapping("/updatePatient")
	public ResponseEntity<WebEndpointResponse> updatePatient(@RequestBody Patient patient) {
		WebEndpointResponse updatePatientResponse = null;
		try {
			patientService.updatePatient(patient);
			updatePatientResponse = new WebEndpointResponse<>("Patient Updated Successfully",
					WebEndpointResponse.STATUS_OK);
		} catch(Exception e) {
			log.info("Excpetion in PatientController : {}", e.getMessage());
			updatePatientResponse = new WebEndpointResponse<>(e.getMessage(), WebEndpointResponse.STATUS_INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(updatePatientResponse.getStatus()).body(updatePatientResponse);
	}
	
	@GetMapping("/listAllPatients")
	public ResponseEntity<WebEndpointResponse> getAllPatients() {
		WebEndpointResponse getAllPatientsResponse = null;
		try {
			List<Patient> list = this.patientService.getAllPatients();
			getAllPatientsResponse = new WebEndpointResponse<>(getAllPatientsResponse, WebEndpointResponse.STATUS_OK);
		} catch(Exception e) {
			log.info("Excpetion in PatientController : {}", e.getMessage());
		}
		return ResponseEntity.status(getAllPatientsResponse.getStatus()).body(getAllPatientsResponse);
	}
	
}
