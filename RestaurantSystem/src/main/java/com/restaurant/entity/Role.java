package com.restaurant.entity;

/**
 * Entity role - id and role name
 * @author Tribel
 *
 */
public class Role {

	private int id;
	private String name;
	
	public Role(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name +  "]";
	}
	
	
}

