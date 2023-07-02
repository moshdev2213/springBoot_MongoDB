package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modal.Taslk;

public interface TaskRepo extends MongoRepository<Taslk, String>{

	List<Taslk> findBySeverity(int severity);

}
