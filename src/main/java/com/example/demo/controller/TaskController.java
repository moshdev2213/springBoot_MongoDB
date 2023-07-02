package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Taslk;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Taslk CreateTask(@RequestBody Taslk taslk) {
		return taskService.addTask(taslk);
	}
	
	@GetMapping
	public List<Taslk> getTask(){
		return taskService.findAllTask();
	}
	
	@GetMapping("/{taskId}")
	public Taslk getTaskById(@PathVariable String taskId) {
		return taskService.getTaskById(taskId);
	}
	
	@GetMapping("/severity/{severity}")
	public List<Taslk> getTaskBySeverity(@PathVariable int severity){
		return taskService.getBySeverity(severity);
	}
	
	@PutMapping
	public Taslk updateTask(@RequestBody Taslk taslk) {
		return taskService.updateTask(taslk);
	}
	
	@DeleteMapping("/{taskId}")
	public String deleteTask(@PathVariable String taskId) {
		return taskService.deleteTask(taskId);
	}
	
}
