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

import com.application.EasyDoctor.Service.VisitService;
import com.application.EasyDoctor.model.Doctor;
import com.application.EasyDoctor.model.Visit;

import lombok.extern.slf4j.Slf4j;

/*
 * Controller class for API operations on Visits repository
 * @Author : Harit M
 * @Date : 16/10/2026
 * 1. addVisit
 * 2. getVisitById
 * 3. updateVisit
 * 4. listAllVisits
 * 5. deleteVisit
 * 6. listAllVisitsByPatientDateDoctor
 */

@RestController
@RequestMapping("/visit")
@Slf4j
public class VisitController {

	private static final Logger log = LoggerFactory.getLogger(VisitController.class);
	
	@Autowired
	VisitService visitService;
	
	@PostMapping("/addVisit")
	public ResponseEntity<WebEndpointResponse> addVisit(@RequestBody Visit visit) {
		WebEndpointResponse addVisitResponse = null;
		try {
			this.visitService.addVisit(visit);
			addVisitResponse = new WebEndpointResponse("New Visit Added Successfully", WebEndpointResponse.STATUS_OK);
		} catch(Exception e) {
			log.info("Exception in VisitController.addVisit" + e.getMessage());
			addVisitResponse = new WebEndpointResponse(e.getMessage(), WebEndpointResponse.STATUS_INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(addVisitResponse.getStatus()).body(addVisitResponse);
	}
	
	@GetMapping("/getVisitById")
	public ResponseEntity<WebEndpointResponse> getVisitById(@RequestParam String visitId) {
		WebEndpointResponse getVisitResponse = null;
		try {
			Visit visit = this.visitService.getVisitById(visitId);
			getVisitResponse = new WebEndpointResponse<>(visit, WebEndpointResponse.STATUS_OK);
		} catch(Exception e) {
			log.info("Exception in VisitController.getVisitById : {}", e.getMessage());
			getVisitResponse = new WebEndpointResponse<>(e.getMessage(), getVisitResponse.STATUS_INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(getVisitResponse.getStatus()).body(getVisitResponse);
	}
	
	@PutMapping("/updateVisit")
	public ResponseEntity<WebEndpointResponse> updateVisit(@RequestBody Visit visit) {
		WebEndpointResponse updateVisitResponse = null;
		try {
			this.visitService.updateVisit(visit);
			updateVisitResponse = new WebEndpointResponse("Visitor details updated successfully", WebEndpointResponse.STATUS_OK);
		} catch(Exception e) {
			log.info("Exception in VisitController.updateVisit : {}", e.getMessage());
			updateVisitResponse = new WebEndpointResponse<>(e.getMessage(), updateVisitResponse.STATUS_INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(updateVisitResponse.getStatus()).body(updateVisitResponse);
	}
	
	@GetMapping("listAllVisits")
	public ResponseEntity<WebEndpointResponse> getAllVisits() {
		WebEndpointResponse getAllVisitsResponse = null;
		try {
			List<Visit> visitsList = this.visitService.getAllVisits();
			getAllVisitsResponse = new WebEndpointResponse(visitsList, WebEndpointResponse.STATUS_OK);
		} catch(Exception e) {
			log.info("Exception in VisitsController.getAllVisits : {}", e.getMessage());
			getAllVisitsResponse = new WebEndpointResponse<>(e.getMessage(),
					WebEndpointResponse.STATUS_INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(getAllVisitsResponse.getStatus()).body(getAllVisitsResponse);
	}
	
	@DeleteMapping("/deleteVisitById")
	public ResponseEntity<WebEndpointResponse> deleteVisitById(@RequestParam String visitId) {
		WebEndpointResponse deleteVisitResponse = null;
		try {
			this.visitService.deleteVisit(visitId);
			deleteVisitResponse = new WebEndpointResponse<>("Visit deleted successfully", WebEndpointResponse.STATUS_OK);
		} catch(Exception e) {
			log.info("Exception in VisitController.deleteVisitById : {}", e.getMessage());
			deleteVisitResponse = new WebEndpointResponse<>(e.getMessage(), 
					WebEndpointResponse.STATUS_INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(deleteVisitResponse.getStatus()).body(deleteVisitResponse);
	}
	
}
