package com.azilab.todolist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="label")
	private String label;
	
	@Column(name="timestamp_due")
	private long timestampDue;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="task_list_id",referencedColumnName="id",nullable=false,unique=true)
	private TaskList mTaskList;

}
