package com.llf.springboot.repository;

import com.llf.springboot.model.UserJpa;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<UserJpa,Long> {

}
