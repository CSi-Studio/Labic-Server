package net.csibio.labic.repository;

import net.csibio.labic.domain.db.UserDO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDO, String> {

    UserDO findByUsername(String username);
}
