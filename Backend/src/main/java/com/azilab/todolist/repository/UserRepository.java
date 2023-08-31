package com.azilab.todolist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.azilab.todolist.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

}
