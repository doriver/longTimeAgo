package com.web.exercise.model;

import java.util.Date;

public class AliveStatus {
	private String name;
	private boolean alive;
	private Date lastAliveTime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public Date getLastAliveTime() {
		return lastAliveTime;
	}
	public void setLastAliveTime(Date lastAliveTime) {
		this.lastAliveTime = lastAliveTime;
	}
	
	
}
