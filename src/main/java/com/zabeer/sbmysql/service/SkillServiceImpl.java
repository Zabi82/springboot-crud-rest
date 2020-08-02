package com.zabeer.sbmysql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabeer.sbmysql.entity.Skill;
import com.zabeer.sbmysql.repository.SkillRepository;

@Service("skillService")
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	private SkillRepository skillRepository;

	@Override
	public Skill addSkill(Skill skill) {
		return skillRepository.save(skill);
	}

	@Override
	public Optional<Skill> getSkillById(Integer id) {
		return skillRepository.findById(id);
		
	}

	@Override
	public List<Skill> getSkillByName(String name) {
		return skillRepository.findByName(name);
	}

	@Override
	public Skill updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSkill(Integer id) {
		skillRepository.deleteById(id);
		
	}

	@Override
	public List<Skill> getAllSkills() {
		List<Skill> skills = new ArrayList<>();
		skillRepository.findAll().forEach(i -> skills.add(i));
		return skills;
	}

}
