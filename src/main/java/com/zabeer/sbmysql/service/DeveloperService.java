package com.zabeer.sbmysql.service;

import java.util.List;

import com.zabeer.sbmysql.entity.Developer;

public interface DeveloperService {
	
	public Developer addDeveloper(Developer developer);
	public Developer getDeveloperById(Integer id);
	public List<Developer> getDeveloperByFirstName(String firstName);
	public Developer updateDeveloper(Developer developer);
	public void deleteDeveloper(Integer id);
	public List<Developer> getAllDevelopers();

}
