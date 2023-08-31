package com.azilab.todolist.repository;

import org.springframework.data.repository.CrudRepository;

import com.azilab.todolist.model.Task;

public interface TaskRepository extends CrudRepository<Task,Long>{

}
