package com.application.EasyDoctor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.EasyDoctor.Service.VisitService;
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
	
	
}
