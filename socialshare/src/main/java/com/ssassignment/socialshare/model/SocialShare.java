package com.ssassignment.socialshare.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SocialShare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String achievement;
    private String platform;
	public SocialShare(Long id, Long userId, String achievement, String platform) {
		super();
		this.id = id;
		this.userId = userId;
		this.achievement = achievement;
		this.platform = platform;
	}
	public SocialShare() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the achievement
	 */
	public String getAchievement() {
		return achievement;
	}
	/**
	 * @param achievement the achievement to set
	 */
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}
	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	@Override
	public String toString() {
		return "SocialShare [id=" + id + ", userId=" + userId + ", achievement=" + achievement + ", platform="
				+ platform + "]";
	}


}
