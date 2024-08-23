package cz.vavrecka.monolittomicroservices.user.repository;

import cz.vavrecka.monolittomicroservices.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> { }