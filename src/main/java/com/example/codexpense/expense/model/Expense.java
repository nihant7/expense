package com.example.codexpense.expense.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "expense")
public class Expense {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	private String script;

	
	private Instant expdate;
	
		
	@ManyToOne
	private Category category;
	
	@JsonIgnore
	@ManyToOne
	private User user;

}
