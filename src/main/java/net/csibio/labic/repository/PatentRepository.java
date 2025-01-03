package net.csibio.labic.repository;

import net.csibio.labic.domain.db.Patent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatentRepository extends MongoRepository<Patent, String> {

}
