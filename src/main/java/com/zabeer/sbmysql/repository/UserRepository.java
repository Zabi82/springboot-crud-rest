package com.zabeer.sbmysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zabeer.sbmysql.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

}
