package com.azilab.todolist.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azilab.todolist.model.TaskList;
import com.azilab.todolist.repository.TaskListRepository;

import lombok.Data;

@Data
@Service
public class TaskListService {

	@Autowired
	private TaskListRepository taskListRepository;
	
	public Optional<TaskList> getTaskList(final Long id) {
		return taskListRepository.findById(id);
	}
	
	public Iterable<TaskList> getTaskLists() {
		return taskListRepository.findAll();
	}
	
	public void deleteTaskList(final Long id) {
		taskListRepository.deleteById(id);
	}
	
	public TaskList saveTaskList(TaskList TaskList) {
		TaskList savedTaskList = taskListRepository.save(TaskList);
		return savedTaskList;
	}
}
