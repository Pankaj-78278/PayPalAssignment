package com.masai.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.inter.TaskService;
import com.masai.model.Sprint;
import com.masai.model.Task;
import com.masai.repository.SprintDao;
import com.masai.repository.TaskDao;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	SprintDao dao;
	
	@Autowired
	TaskDao taskDao;
	
	@Override
	public Map<String, Object> add_sprint(String sprint_name) {
		Map<String, Object> response = new HashMap<String,Object>();
		try {
			Sprint data =  dao.findByName(sprint_name);
			if (data != null) {
				response.put("status", "Already_Exist");
				response.put("message", "Sprint Already Exist");
			}else {
				Sprint data1 = new Sprint();
				data1.setName(sprint_name);
				data1.setStatus("Active");
				data1.setCreatedAt(new Date());
				Sprint save_repository = dao.save(data1);
				if (save_repository == null) {
					response.put("status", "failed");
					response.put("message", "Something Went Wrong");
				}else {
					response.put("status", "Successful");
					response.put("message", "Data Saved Successfully");
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failed");
			response.put("message", "Something Went Wrong");
		}
		return response;
	}

	@Override
	public Map<String, Object> add_task(Task task) {
		Map<String, Object> response = new HashMap<String,Object>();
		try {
			Task task_data = taskDao.findByTaskNameAndSprintIdAndTaskType(task.getTaskName(),task.getSprintId(),task.getTaskType()); 
			if (task_data != null) {
				response.put("status", "Already_Exist");
				response.put("message", "Task Already Exist");
			}else {
				task.setCreatedAt(new Date());
				task.setStatus("Assigned");
				Task saved_data = taskDao.save(task);
				if (saved_data == null) {
					response.put("status", "failed");
					response.put("message", "Something Went Wrong");
				}else {
					response.put("status", "Successful");
					response.put("message", "Data Saved Successfully");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failed");
			response.put("message", "Something Went Wrong");
		}
		return response;
	}

	@Override
	public Map<String, Object> change_assignee(Task task) {
		Map<String, Object> response = new HashMap<String,Object>();
		try {
			Task task_data = taskDao.findById(task.getSno());
			if (task_data == null) {
				response.put("status", "Not_Exist");
				response.put("message", "Data does not Exist");
			}else {
				task_data.setAssignedTo(task.getAssignedTo());
				task_data.setUpdatedAt(new Date());
				Task t =  taskDao.save(task_data);
				if (t == null) {
					response.put("status", "failed");
					response.put("message", "Something Went Wrong");
				}else {
					response.put("status", "Success");
					response.put("message", "Data Updated Successfully");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failed");
			response.put("message", "Something Went Wrong");
		}
		return response;
	}

	@Override
	public Map<String, Object> change_status(Task task) {
		Map<String, Object> response = new HashMap<String,Object>();
		try {
			Task task_data = taskDao.findById(task.getSno());
			if (task_data == null) {
				response.put("status", "Not_Exist");
				response.put("message", "Data does not Exist");
			}else {
				task_data.setStatus(task.getStatus());
				task_data.setUpdatedAt(new Date());
				Task t =  taskDao.save(task_data);
				if (t == null) {
					response.put("status", "failed");
					response.put("message", "Something Went Wrong");
				}else {
					response.put("status", "Success");
					response.put("message", "Status Updated Successfully");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failed");
			response.put("message", "Something Went Wrong");
		}
		return response;
	}

	@Override
	public Map<String, Object> get_sprinttask(String id) {
		Map<String, Object> response = new HashMap<String,Object>();
		try {
			Sprint sprint  = dao.findById(Integer.parseInt(id));
			if (sprint == null) {
				response.put("status", "Not_Exist");
				response.put("message", "Data does not Exist");
			}else {
				response.put("data", sprint);
				response.put("status", "Success");
				response.put("message", "Data Fetched Successfully");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failed");
			response.put("message", "Something Went Wrong");
		}
		return response;
	}

	@Override
	public Map<String, Object> get_usertasks(String user) {
		Map<String, Object> response = new HashMap<String,Object>();
		try {
			List<Task> task = taskDao.findByAssignedTo(user);
			if (task == null) {
				response.put("status", "Not_Exist");
				response.put("message", "Data does not Exist");
			}else {
				response.put("data", task);
				response.put("status", "Success");
				response.put("message", "Data Fetched Successfully");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failed");
			response.put("message", "Something Went Wrong");
		}
		return response;
	}

}