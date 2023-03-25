package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Task;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {
	
	public Task findByTaskNameAndSprintIdAndTaskType(String taskName,int sprintId,String taskType);
	public Task findById(int sno);
	public List<Task> findByAssignedTo(String name);

}