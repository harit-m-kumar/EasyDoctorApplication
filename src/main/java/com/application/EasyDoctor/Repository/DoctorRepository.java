package com.application.EasyDoctor.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.application.EasyDoctor.model.Doctor;

public interface DoctorRepository extends MongoRepository<Doctor, String> {

}
