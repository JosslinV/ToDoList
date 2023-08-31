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

import com.azilab.todolist.model.TaskList;
import com.azilab.todolist.model.User;
import com.azilab.todolist.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// CREATE
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	// READ
	
	@GetMapping("/user")
	public Iterable<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") final Long id) {
		Optional<User> user = userService.getUser(id);
		
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	
	// UPDATE
	
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") final Long id, @RequestBody User user) {
		Optional<User> u = userService.getUser(id);
		if(u.isPresent()) {
			User currentUser = u.get();
			
			String login = user.getLogin();
			if(login != null) {
				currentUser.setLogin(login);
			}
			
			String password = user.getPassword();
			if(password != null) {
				currentUser.setPassword(password);
			}
			
			List<TaskList> lstOfTaskList = user.getLstOfTaskList();
			if(lstOfTaskList != null) {
				currentUser.setLstOfTaskList(lstOfTaskList);
			}
			userService.saveUser(currentUser);
			return currentUser;
		} else {
			return null;
		}
	}
	// DELETE

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") final Long id) {
		userService.deleteUser(id);
	}
}
