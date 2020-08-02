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
import com.zabeer.sbmysql.exception.PreconditionsFailedException;
import com.zabeer.sbmysql.repository.DeveloperRepository;

@Service("developerService")
public class DeveloperServiceImpl implements DeveloperService {

	@Autowired
	private DeveloperRepository developerRepository;

	@Autowired
	private SkillService skillService;

	@Override
	public Developer addDeveloper(Developer developer) throws PreconditionsFailedException {
		// validate skill, only allow skills which are already existing
		boolean isValid = true;
		Set<Skill> validSkills = new HashSet<>();
		if (developer.getSkills() != null && !developer.getSkills().isEmpty()) {
			for (Skill skill : developer.getSkills()) {
				if (skill != null && skill.getId() != 0) {
					// fetch the Skill object from DB
					Optional<Skill> existingSkill = skillService.getSkillById(skill.getId());
					if (existingSkill.isPresent()) {
						validSkills.add(existingSkill.get());
					} else {
						isValid = false;
						break;
					}
				} else {
					isValid = false;
					break;
				}
			}

		}
		if (isValid) {
			developer.setSkills(validSkills);
			return developerRepository.save(developer);
		} else {
			throw new PreconditionsFailedException("Invalid skill data passed");
		}

	}

	@Override
	public Optional<Developer> getDeveloperById(Integer id) {
		return developerRepository.findById(id);
	}

	@Override
	public List<Developer> getDeveloperByFirstName(String firstName) {
		return developerRepository.findByFirstName(firstName);
	}

	@Override
	public Developer updateDeveloper(Developer developer) throws PreconditionsFailedException {
		// validate skill, only allow skills which are already existing
		boolean isValid = true;
		Set<Skill> validSkills = new HashSet<>();
		// check if it exist in DB
		Optional<Developer> devFromDBOpt = getDeveloperById(developer.getId());
		Developer devFromDB = null;
		if (devFromDBOpt.isPresent()) {
			devFromDB = devFromDBOpt.get();
		}
		if (devFromDB != null) {
			devFromDB.setFirstName(developer.getFirstName());
			devFromDB.setLastName(developer.getLastName());

			if (developer.getSkills() != null && !developer.getSkills().isEmpty()) {
				for (Skill skill : developer.getSkills()) {
					if (skill != null && skill.getId() != 0) {
						// fetch the Skill object from DB
						Optional<Skill> existingSkill = skillService.getSkillById(skill.getId());
						if (existingSkill.isPresent()) {
							validSkills.add(existingSkill.get());
						} else {
							isValid = false;
							break;
						}
					} else {
						isValid = false;
						break;
					}
				}

			}

		}
		if (isValid) {
			devFromDB.setSkills(validSkills);
			return developerRepository.save(devFromDB);
		} else {
			throw new PreconditionsFailedException("Invalid Skills data passed");
		}

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
