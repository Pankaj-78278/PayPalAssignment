package com.masai.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.inter.TaskService;
import com.masai.model.Task;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@PostMapping("/add_sprint")
	public ResponseEntity<Map<String, Object>> add_sprint(@RequestParam("sprint_name") String sprint_name) throws IOException{
		Map<String, Object> response = new HashMap<String,Object>();
		response = taskService.add_sprint(sprint_name);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
	}

	@PostMapping("/add_task")
	public ResponseEntity<Map<String, Object>> add_task(@RequestBody Task task) throws IOException{
		Map<String, Object> response = new HashMap<String,Object>();
		response = taskService.add_task(task);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@PostMapping("/change_assignee") // sno and assignedTo will come from frontend mandatory
	public ResponseEntity<Map<String, Object>> change_assignee(@RequestBody Task task) throws IOException{
		Map<String, Object> response = new HashMap<String,Object>();
		response = taskService.change_assignee(task);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
	}
	
	@PostMapping("/change_status") // sno and status will come from frontend mandatory
	public ResponseEntity<Map<String, Object>> change_status(@RequestBody Task task) throws IOException{
		Map<String, Object> response = new HashMap<String,Object>();
		response = taskService.change_status(task);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
	}
	
	@PostMapping("/get_sprinttask") // sno and status will come from frontend mandatory
	public ResponseEntity<Map<String, Object>> get_sprinttask(@RequestParam("sprintId") String id) throws IOException{
		Map<String, Object> response = new HashMap<String,Object>();
		response = taskService.get_sprinttask(id);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
	}
	@PostMapping("/get_usertasks") // sno and status will come from frontend mandatory
	public ResponseEntity<Map<String, Object>> get_usertasks(@RequestParam("user") String user) throws IOException{
		Map<String, Object> response = new HashMap<String,Object>();
		response = taskService.get_usertasks(user);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
	}
	
	
}