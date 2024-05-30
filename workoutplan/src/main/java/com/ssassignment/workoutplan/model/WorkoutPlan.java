package com.ssassignment.workoutplan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId; // If null, it is a pre-designed workout plan
    private String name;
    private String description;
    private List<String> exercises;
	public WorkoutPlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WorkoutPlan(Long id, Long userId, String name, String description, List<String> exercises) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.exercises = exercises;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the exercises
	 */
	public List<String> getExercises() {
		return exercises;
	}
	/**
	 * @param exercises the exercises to set
	 */
	public void setExercises(List<String> exercises) {
		this.exercises = exercises;
	}
	@Override
	public String toString() {
		return "WorkoutPlan [id=" + id + ", userId=" + userId + ", name=" + name + ", description=" + description
				+ ", exercises=" + exercises + "]";
	}

    // Constructors, getters, and setters
    
}
