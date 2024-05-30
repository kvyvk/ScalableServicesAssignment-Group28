package com.ssassignment.integration.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WearableDeviceData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String deviceType;
    private String deviceId;
    private String dataType;
    private String dataValue;
    private String timestamp;
	public WearableDeviceData(Long id, Long userId, String deviceType, String deviceId, String dataType,
			String dataValue, String timestamp) {
		super();
		this.id = id;
		this.userId = userId;
		this.deviceType = deviceType;
		this.deviceId = deviceId;
		this.dataType = dataType;
		this.dataValue = dataValue;
		this.timestamp = timestamp;
	}
	public WearableDeviceData() {
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
	 * @return the deviceType
	 */
	public String getDeviceType() {
		return deviceType;
	}
	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}
	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	/**
	 * @return the dataValue
	 */
	public String getDataValue() {
		return dataValue;
	}
	/**
	 * @param dataValue the dataValue to set
	 */
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "WearableDeviceData [id=" + id + ", userId=" + userId + ", deviceType=" + deviceType + ", deviceId="
				+ deviceId + ", dataType=" + dataType + ", dataValue=" + dataValue + ", timestamp=" + timestamp + "]";
	}

    // Constructors, getters, and setters
}
