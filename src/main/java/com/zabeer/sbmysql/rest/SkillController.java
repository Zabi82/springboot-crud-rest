package com.zabeer.sbmysql.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zabeer.sbmysql.entity.Skill;
import com.zabeer.sbmysql.service.SkillService;

@RestController
public class SkillController {
	
	
	@Autowired
	private SkillService skillService;
	
	
	@GetMapping("/skill/{id}")
	public Skill getSkill(@PathVariable ("id") Integer id) {
		return skillService.getSkillById(id);
	}
	
	/*
	 * @GetMapping("/skill/{name}") public List<Skill> getSkillByName(@PathVariable
	 * ("name") String name) { return skillService.getSkillByName(name); }
	 */
	
	@GetMapping("/skill")
	public List<Skill> getAllSkills() {
		return skillService.getAllSkills();
	}
	
	@PostMapping("/skill")
	public Skill addSkill(@RequestBody Skill skill) {
		return skillService.addSkill(skill);
	}
	
	@PutMapping("/skill")
	public Skill updateSkill(@RequestBody Skill skill) {
		return skillService.updateSkill(skill);
	}
	
	@DeleteMapping("/skill/{id}")
	public String deleteSkill(@PathVariable ("id") Integer id) {
		skillService.deleteSkill(id);
		return "SUCCESS";
	}
	

}
