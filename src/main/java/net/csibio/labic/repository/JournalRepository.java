package net.csibio.labic.repository;

import net.csibio.labic.domain.db.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<Journal, String> {

}
