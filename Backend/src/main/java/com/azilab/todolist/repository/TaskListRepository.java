package com.azilab.todolist.repository;

import org.springframework.data.repository.CrudRepository;

import com.azilab.todolist.model.TaskList;

public interface TaskListRepository extends CrudRepository<TaskList,Long> {

}
