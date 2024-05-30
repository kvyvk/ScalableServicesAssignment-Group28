package com.ssassignment.progress.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long goalId;
    private double value;
    private LocalDateTime timestamp;
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
	 * @return the goalId
	 */
	public Long getGoalId() {
		return goalId;
	}
	/**
	 * @param goalId the goalId to set
	 */
	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}
	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}
	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Progress [id=" + id + ", userId=" + userId + ", goalId=" + goalId + ", value=" + value + ", timestamp="
				+ timestamp + "]";
	}
	public Progress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Progress(Long id, Long userId, Long goalId, double value, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.userId = userId;
		this.goalId = goalId;
		this.value = value;
		this.timestamp = timestamp;
	}

    
}
