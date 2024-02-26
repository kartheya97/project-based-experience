package com.example.webapplication.todoapplication.pojo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private    int        id;
	private    String     username;
	
	@Size(min=10, message="Enter atleast 10 characters")
	private    String     description;
	private    LocalDate  targetDate;
	private    boolean    isCompleted;
	
	public Todo() {
		
	}
	
	public Todo(int id, String username, String description, LocalDate targetDate, boolean isCompleted) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isCompleted = isCompleted;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", isCompleted=" + isCompleted + "]";
	}

}
