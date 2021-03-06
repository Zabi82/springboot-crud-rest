package com.zabeer.sbmysql.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zabeer.sbmysql.entity.Developer;
import com.zabeer.sbmysql.exception.PreconditionsFailedException;
import com.zabeer.sbmysql.exception.ResourceNotFoundException;
import com.zabeer.sbmysql.service.DeveloperService;

@RestController
public class DeveloperController {

	
	@Autowired
	private DeveloperService developerService;
	
	
	@GetMapping("/developer/{id}")
	public Developer getDeveloper(@PathVariable ("id") Integer id) throws ResourceNotFoundException {
		Optional<Developer> developer = developerService.getDeveloperById(id);
		if(developer.isPresent()) {
			return developer.get();
		}
		else {
			throw new ResourceNotFoundException("Developer not found");
		}
	}
	
	/*
	 * @GetMapping("/developer/{firstName}") public List<Developer>
	 * getDeveloperByFirstName(@PathVariable ("firstName") String firstName) {
	 * return developerService.getDeveloperByFirstName(firstName); }
	 */
	
	@DeleteMapping("/developer/{id}")
	public String deleteDeveloper(@PathVariable ("id") Integer id) {
		developerService.deleteDeveloper(id);
		return "SUCCESS";
	}
	
	@PostMapping("/developer")
	public Developer addDeveloper(@RequestBody Developer developer) throws PreconditionsFailedException{
		return developerService.addDeveloper(developer);
	}
	
	@PutMapping("/developer")
	public Developer updateDeveloper(@RequestBody Developer developer) throws PreconditionsFailedException {
		return developerService.updateDeveloper(developer);
	}
	
	@GetMapping("/developer")
	public List<Developer> getAllDeveloper() {
		return developerService.getAllDevelopers();
	}
}
