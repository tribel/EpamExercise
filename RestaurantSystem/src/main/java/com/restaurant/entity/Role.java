package com.restaurant.entity;

/**
 * This class implements role representation.
 * It contains id and name of the role.
 * @author Tribel
 *
 */
public class Role {

	private int id;
	private String name;
	
	/**
	 * Constructs default instance.
	 */
	public Role(){
	}

	/**
	 * Constructs {@link Role} instance with special parameters.
	 * @param id of the particular role.
	 * @param name {@link String} of the role.
	 */
	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

