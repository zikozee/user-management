package com.isw.usermanagement.repo;

import com.isw.usermanagement.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


/**
 * @author : Ezekiel Eromosei
 * @created : 06 April 2022
 */


public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByFirstNameAndDeleted(String firstName, boolean deleted);

    List<User> findAllByDeleted(boolean deleted);

    Optional<User> findByApplicationId(String appId);
}
