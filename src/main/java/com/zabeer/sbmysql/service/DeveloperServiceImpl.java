package com.zabeer.sbmysql.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabeer.sbmysql.entity.Developer;
import com.zabeer.sbmysql.entity.Skill;
import com.zabeer.sbmysql.repository.DeveloperRepository;

@Service("developerService")
public class DeveloperServiceImpl implements DeveloperService {
	
	@Autowired
	private DeveloperRepository developerRepository;
	
	@Autowired
	private SkillService skillService;
	

	@Override
	public Developer addDeveloper(Developer developer) {
		//validate skill, only allow skills which are already existing
		boolean isValid = true;
		Set<Skill> validSkills = new HashSet<>();
		if(developer.getSkills() != null && !developer.getSkills().isEmpty()) {
			for(Skill skill : developer.getSkills()) {
				if(skill != null && Integer.valueOf(skill.getId()) != null) {
					//fetch the Skill object from DB 
					Skill existingSkill = skillService.getSkillById(skill.getId());
					if(existingSkill != null) {
						validSkills.add(existingSkill);
					}
					else {
						isValid = false;
						break;
					}
				}
				else {
					isValid = false;
					break;
				}
			}
			
		}
		if(isValid) {
			developer.setSkills(validSkills);
		}
		else {
			//TODO handle
		}
		return developerRepository.save(developer);
	}

	@Override
	public Developer getDeveloperById(Integer id) {
		Optional<Developer> developer = developerRepository.findById(id);
		return developer.get();
	}

	@Override
	public List<Developer> getDeveloperByFirstName(String firstName) {
		return developerRepository.findByFirstName(firstName);
	}

	@Override
	public Developer updateDeveloper(Developer developer) {
		//check if it exist in DB 
		Developer devFromDB = getDeveloperById(developer.getId());
		if(devFromDB != null) {
			devFromDB.setFirstName(developer.getFirstName());
			devFromDB.setLastName(developer.getLastName());
			//validate skill, only allow skills which are already existing
			boolean isValid = true;
			Set<Skill> validSkills = new HashSet<>();
			if(developer.getSkills() != null && !developer.getSkills().isEmpty()) {
				for(Skill skill : developer.getSkills()) {
					if(skill != null && Integer.valueOf(skill.getId()) != null) {
						//fetch the Skill object from DB 
						Skill existingSkill = skillService.getSkillById(skill.getId());
						if(existingSkill != null) {
							validSkills.add(existingSkill);
						}
						else {
							isValid = false;
							break;
						}
					}
					else {
						isValid = false;
						break;
					}
				}
				
			}
			if(isValid) {
				devFromDB.setSkills(validSkills);
			}
			else {
				//TODO handle
			}
		}
		return developerRepository.save(devFromDB);
		
	}

	@Override
	public void deleteDeveloper(Integer id) {
		developerRepository.deleteById(id);
		
	}

	@Override
	public List<Developer> getAllDevelopers() {
		List<Developer> devList = new ArrayList<>();
		
		developerRepository.findAll().forEach(item -> devList.add(item));
		return devList;
	}

}
