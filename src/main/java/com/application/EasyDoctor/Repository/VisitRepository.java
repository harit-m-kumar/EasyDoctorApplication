package com.application.EasyDoctor.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.application.EasyDoctor.model.Visit;

public interface VisitRepository extends MongoRepository<Visit, String> {

}
