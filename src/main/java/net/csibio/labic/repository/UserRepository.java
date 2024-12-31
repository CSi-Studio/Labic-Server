package net.csibio.labic.repository;

import net.csibio.labic.domain.db.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);

}
