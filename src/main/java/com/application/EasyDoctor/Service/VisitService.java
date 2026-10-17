package com.application.EasyDoctor.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.application.EasyDoctor.Repository.VisitRepository;
import com.application.EasyDoctor.model.Doctor;
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
	
	public Visit getVisitById(String visitId) throws Exception {
		log.info("Inside VisitService.getVisitById");
		Optional<Visit> visit = this.visitRepository.findById(visitId);
		if (visit.isPresent()) {
			return visit.get();
		} else {
			throw new Exception("Visit with the given id does not exist : " + visitId);
		}
	}
	
	public void updateVisit(Visit visit) throws Exception {
		log.info("Inside VisitService.updateVisit");
		Optional<Visit> fetchedVisitOptional = this.visitRepository.findById(visit.getVisitId());
		if (fetchedVisitOptional.isPresent()) {
			Visit fetchedVisit = fetchedVisitOptional.get();
			
			fetchedVisit.setConsultedDoctorId(visit.getConsultedDoctorId());
			fetchedVisit.setDateAndTimeOfVisit(visit.getDateAndTimeOfVisit());
			fetchedVisit.setDiagnosis(visit.getDiagnosis());
			fetchedVisit.setFollowUpDate(visit.getFollowUpDate());
			fetchedVisit.setPatientId(visit.getPatientId());
			fetchedVisit.setSymptoms(visit.getSymptoms());

			
			this.visitRepository.save(fetchedVisit);
			log.info("Visit with the given id has been updated : " + fetchedVisit.getVisitId());
		} else {
			log.info("Searched visit does not exist with id : {}", visit.getVisitId());
			throw new Exception("Searched doctor does not exist with id : " + visit.getVisitId());
		}
	}
	
	public List<Visit> getAllVisits() {
		log.info("Inside VisitService.getAllVisits");
		List<Visit> visitsList = this.visitRepository.findAll();
		return visitsList;
	}
	
	public void deleteVisit(String visitId) throws Exception {
		log.info("Inside VisitService.deleteVisit");
		Optional<Visit> visitOptional = this.visitRepository.findById(visitId);
		if (visitOptional.isPresent()) {
			this.visitRepository.deleteById(visitId);
		} else {
			log.info("Visit with the given id does not exist : " + visitId);
			throw new Exception("Visit with the given id does not exist : " + visitId);
		}
	}
	
}
