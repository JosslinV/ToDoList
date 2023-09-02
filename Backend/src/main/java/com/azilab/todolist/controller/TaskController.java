package com.azilab.todolist.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.azilab.todolist.model.Task;
import com.azilab.todolist.model.TaskList;
import com.azilab.todolist.service.TaskListService;
import com.azilab.todolist.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskListService taskListService;
	
	// CREATE
	
	@PostMapping("/task/{taskListId}")
	public Task createTask(@PathVariable("taskListId") final Long taskListId, @RequestBody Task task) {
		Optional<TaskList> taskList = taskListService.getTaskList(taskListId);
		
		if(taskList.isPresent()) {
			task.setMTaskList(taskList.get());
			return taskService.saveTask(task);
		} else {
			return null;
		}
	}
	
	// READ
	
	@GetMapping("/task")
	public Iterable<Task> getTasks() {
		return taskService.getTasks();
	}
	
	@GetMapping("/task/{id}")
	public Task getTaskById(@PathVariable("id") final Long id) {
		Optional<Task> task = taskService.getTask(id);
		
		if(task.isPresent()) {
			return task.get();
		} else {
			return null;
		}
	}
	
	// UPDATE
	
	@PutMapping("/task/{id}")
	public Task updateTask(@PathVariable("id") final Long id, @RequestBody Task task) {
		Optional<Task> u = taskService.getTask(id);
		if(u.isPresent()) {
			Task currentTask = u.get();
			
			String label = task.getLabel();
			if(label != null) {
				currentTask.setLabel(label);
			}
			
			Long timestampDue = task.getTimestampDue();
			if(timestampDue != null) {
				currentTask.setTimestampDue(timestampDue);
			}
			
			TaskList taskList = task.getMTaskList();
			if(taskList != null) {
				currentTask.setMTaskList(taskList);
			}

			taskService.saveTask(currentTask);
			return currentTask;
		} else {
			return null;
		}
	}
	// DELETE

	@DeleteMapping("/task/{id}")
	public void deleteTask(@PathVariable("id") final Long id) {
		taskService.deleteTask(id);
	}
}
