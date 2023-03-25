package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Sprint;

@Repository
public interface SprintDao extends JpaRepository<Sprint, Integer> {
	
	Sprint findByName(String sprintName);
	Sprint findById(int id);

}