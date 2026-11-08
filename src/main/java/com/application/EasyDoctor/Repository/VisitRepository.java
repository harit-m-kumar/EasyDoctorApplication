package com.application.EasyDoctor.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.application.EasyDoctor.model.Visit;

public interface VisitRepository extends MongoRepository<Visit, String> {

	@Query(value = "{ 'patient_id' : ?0,  'consulted_doctor_id' : ?1, 'date_of_visit' : { $gte : ?2, $lte : ?3 } }")
	List<Visit> findByPatientIdAndDoctorIdAndVisitDateBetween(String patientId, String doctorId, Date startDate, Date endDate);
	
}
