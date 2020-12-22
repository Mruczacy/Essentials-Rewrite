package org.dss.er.object;

import java.util.List;
import java.util.UUID;

public class User {
	
	private String name;
	private UUID uuid;
	private List<UUID> teammates;
	private List<Home> homes;
	
	public User(String name, UUID uuid, List<UUID> teammates, List<Home> homes) {
		this.name = name;
		this.uuid = uuid;
		this.teammates = teammates;
		this.homes = homes;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public List<UUID> getTeammates() {
		return teammates;
	}
	public void setTeammates(List<UUID> teammates) {
		this.teammates = teammates;
	}
	public List<Home> getHomes() {
		return homes;
	}
	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}
}
