package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.Taslk;
import com.example.demo.repo.TaskRepo;

@Service
public class TaskService {
	@Autowired
	private TaskRepo taskRepo;
	
	//crud starts here
	
	//create
	public Taslk addTask(Taslk taslk) {
		taslk.setTaskId(UUID.randomUUID().toString().split("-")[0]);
		return taskRepo.save(taslk);
	}
	
	//read
	public List<Taslk> findAllTask(){
		return taskRepo.findAll();
	}
	
	public Taslk getTaskById(String taskId) {
		return taskRepo.findById(taskId).get();
	}
	
	public List<Taslk> getBySeverity(int severity) {
		return taskRepo.findBySeverity(severity);
	}
	
	//update
	public Taslk updateTask(Taslk taslk) {
		//getExcisting doc from DB
		//populate new value from exixting object
		Taslk exTaslk = taskRepo.findById(taslk.getTaskId()).get();
		
		exTaslk.setAssigne(taslk.getAssigne());
		exTaslk.setDescription(taslk.getDescription());
		exTaslk.setSeverity(taslk.getSeverity());
		exTaslk.setStoryPoint(taslk.getStoryPoint());
		
		return taskRepo.save(exTaslk);
		
	}
	
	//delete
	public String deleteTask(String taskID) {
		taskRepo.deleteById(taskID);
		return "Deleted Succesfully";
	}
	
}
