package com.llf.springboot.repository;

import com.llf.springboot.model.UserJpa;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<UserJpa, Long> {

}

