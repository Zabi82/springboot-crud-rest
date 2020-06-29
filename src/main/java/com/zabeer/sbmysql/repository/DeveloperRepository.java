package com.zabeer.sbmysql.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zabeer.sbmysql.entity.Developer;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Integer> {
	
	public List<Developer> findByFirstName(String firstName);
	public List<Developer> findByLastName(String lastName);

}
