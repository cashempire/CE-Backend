package org.cashempire.repository;

import org.cashempire.module.ClientLaunch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientLaunchRepository extends MongoRepository<ClientLaunch,String> {
}
