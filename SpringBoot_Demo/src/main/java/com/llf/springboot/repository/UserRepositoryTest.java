package com.llf.springboot.repository;

import com.llf.springboot.model.UserJpa;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepositoryTest extends Repository<UserJpa,Long> {
    List<UserJpa> findByName(String name);
}
