package com.azilab.todolist.controller;

import java.util.List;
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
import com.azilab.todolist.model.User;
import com.azilab.todolist.service.TaskListService;
import com.azilab.todolist.service.UserService;

@RestController
public class TaskListController {
	
	@Autowired
	private TaskListService taskListService;
	
	@Autowired
	private UserService userService;
	
	// CREATE
	
	@PostMapping("/tasklist/{userId}")
	public TaskList createTaskList(@PathVariable("userId") final Long userId, @RequestBody TaskList taskList) {
		Optional<User> user = userService.getUser(userId);
		
		if(user.isPresent()) {
			taskList.setMUser(user.get());
			return taskListService.saveTaskList(taskList);
		} else {
			return null;
		}

	}
	
	// READ
	
	@GetMapping("/tasklist")
	public Iterable<TaskList> getTaskLists() {
		return taskListService.getTaskLists();
	}
	
	@GetMapping("/tasklist/{id}")
	public TaskList getTaskListById(@PathVariable("id") final Long id) {
		Optional<TaskList> taskList = taskListService.getTaskList(id);
		
		if(taskList.isPresent()) {
			return taskList.get();
		} else {
			return null;
		}
	}
	
	// UPDATE
	
	@PutMapping("/tasklist/{id}")
	public TaskList updateTaskList(@PathVariable("id") final Long id, @RequestBody TaskList taskList) {
		Optional<TaskList> u = taskListService.getTaskList(id);
		if(u.isPresent()) {
			TaskList currentTaskList = u.get();
			
			String label = taskList.getLabel();
			if(label != null) {
				currentTaskList.setLabel(label);
			}
			
			User user = taskList.getMUser();
			if(user != null) {
				currentTaskList.setMUser(user);
			}
			
			List<Task> lstOfTask = taskList.getLstOfTask();
			if(lstOfTask != null) {
				currentTaskList.setLstOfTask(lstOfTask);
			}
			taskListService.saveTaskList(currentTaskList);
			return currentTaskList;
		} else {
			return null;
		}
	}
	// DELETE

	@DeleteMapping("/tasklist/{id}")
	public void deleteTaskList(@PathVariable("id") final Long id) {
		taskListService.deleteTaskList(id);
	}
}
