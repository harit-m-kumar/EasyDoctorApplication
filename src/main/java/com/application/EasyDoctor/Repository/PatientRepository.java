package com.application.EasyDoctor.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.application.EasyDoctor.model.Patient;

public interface PatientRepository extends MongoRepository<Patient, String> {

}
