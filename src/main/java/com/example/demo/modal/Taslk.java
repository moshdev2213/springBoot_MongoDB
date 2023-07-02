package com.example.demo.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "tasks")
public class Taslk {
	@Id
	private String taskId;
	private String description;
	private String assigne;
	private int severity;
	private int storyPoint;
}
