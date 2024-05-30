package com.ssassignment.goal.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String type; // e.g., weight loss, endurance improvement, muscle gain
    private double targetValue;
    private double currentValue;
	public Goal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goal(Long id, Long userId, String type, double targetValue, double currentValue) {
		super();
		this.id = id;
		this.userId = userId;
		this.type = type;
		this.targetValue = targetValue;
		this.currentValue = currentValue;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getTargetValue() {
		return targetValue;
	}
	public void setTargetValue(double targetValue) {
		this.targetValue = targetValue;
	}
	public double getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
	@Override
	public String toString() {
		return "Goal [id=" + id + ", userId=" + userId + ", type=" + type + ", targetValue=" + targetValue
				+ ", currentValue=" + currentValue + "]";
	}


}
