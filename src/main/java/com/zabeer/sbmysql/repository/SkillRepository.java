package com.zabeer.sbmysql.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zabeer.sbmysql.entity.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
	
	public List<Skill> findByName(String name);

}
