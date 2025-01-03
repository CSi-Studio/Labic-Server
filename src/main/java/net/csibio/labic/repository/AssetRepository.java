package net.csibio.labic.repository;

import net.csibio.labic.domain.db.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssetRepository extends MongoRepository<Asset, String> {

}
