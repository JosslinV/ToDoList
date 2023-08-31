package com.azilab.todolist.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="task_list")
public class TaskList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="label")
	private String label;
	
	@OneToMany(mappedBy="mTaskList")
	private List<Task> lstOfTask;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="user_id",referencedColumnName="id",nullable=false,unique=true)
	private User mUser;

}
