package com.application.EasyDoctor.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.application.EasyDoctor.Repository.VisitRepository;
import com.application.EasyDoctor.model.Visit;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VisitService {

	private static final Logger log = LoggerFactory.getLogger(VisitService.class);
	
	private final VisitRepository visitRepository;
	
	public VisitService(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}
	
	public void addVisit(Visit visit) throws Exception {
		log.info("Inside VisitService.addVisit");
		Visit newVisit = new Visit();
		
		if (visit != null) {
			newVisit.setConsultedDoctorId(visit.getConsultedDoctorId());
			newVisit.setDateAndTimeOfVisit(visit.getDateAndTimeOfVisit());
			newVisit.setDiagnosis(visit.getDiagnosis());
			newVisit.setFollowUpDate(visit.getFollowUpDate());
			newVisit.setPatientId(visit.getPatientId());
			newVisit.setSymptoms(visit.getSymptoms());
			newVisit.setVisitId(visit.getVisitId());
			
			Visit addedVisit = this.visitRepository.save(newVisit);
			log.info("New visit inserted with id : {}", addedVisit.getVisitId());
		} else {
			log.error("");
			throw new Exception("Visit object is null");
		}
		return;
	}
	
}
