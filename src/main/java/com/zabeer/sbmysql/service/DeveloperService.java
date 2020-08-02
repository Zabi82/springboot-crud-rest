package com.zabeer.sbmysql.service;

import java.util.List;
import java.util.Optional;

import com.zabeer.sbmysql.entity.Developer;
import com.zabeer.sbmysql.exception.PreconditionsFailedException;

public interface DeveloperService {
	
	public Developer addDeveloper(Developer developer) throws PreconditionsFailedException;
	public Optional<Developer> getDeveloperById(Integer id);
	public List<Developer> getDeveloperByFirstName(String firstName);
	public Developer updateDeveloper(Developer developer) throws PreconditionsFailedException;
	public void deleteDeveloper(Integer id);
	public List<Developer> getAllDevelopers();

}
