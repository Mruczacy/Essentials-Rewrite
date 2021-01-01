package org.dss.er.object;

public class Home {

	private int id;
	private String worldname;
	private int x;
	private int y;
	private int z;
	private String name;
	private int used;
	
	public Home(int id, String w, int x, int y, int z, String name, int used) {
		this.worldname = w;
		this.x = x;
		this.y = y;
		this.z = z;
		this.name = name;
		this.used = used;
	}
	
	public int getID() { 
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getWorld() {
		return worldname;
	}
	public void setWorld(String world) {
		this.worldname = world;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	
}
