package com.zabeer.sbmysql.service;

import java.util.List;

import com.zabeer.sbmysql.entity.Skill;

public interface SkillService {
	
	public Skill addSkill(Skill skill);
	public Skill getSkillById(Integer id);
	public List<Skill> getSkillByName(String name);
	public Skill updateSkill(Skill skill);
	public void deleteSkill(Integer id);
	public List<Skill> getAllSkills();
	

}
