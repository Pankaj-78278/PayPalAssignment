package com.masai.inter;

import java.util.Map;

import com.masai.model.Task;

public interface TaskService {

	public Map<String, Object> add_sprint(String sprint_name);
	public Map<String, Object> add_task(Task task);
	public Map<String, Object> change_assignee(Task task);
	public Map<String, Object> change_status(Task task);
	public Map<String, Object> get_sprinttask(String id);
	public Map<String, Object> get_usertasks(String user);
	

}
