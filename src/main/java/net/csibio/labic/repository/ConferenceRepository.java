package net.csibio.labic.repository;

import net.csibio.labic.domain.db.Conference;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConferenceRepository extends MongoRepository<Conference, String> {

}
