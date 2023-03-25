package com.masai.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Sprint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sno;
	private String name;
	private String status;
	private Date createdAt;
	
	@OneToMany
	@JoinColumn(name = "sprintId")
	private List<Task> tasks;

}