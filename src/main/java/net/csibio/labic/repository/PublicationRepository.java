package net.csibio.labic.repository;

import net.csibio.labic.domain.db.Publication;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublicationRepository extends MongoRepository<Publication, String> {


}
