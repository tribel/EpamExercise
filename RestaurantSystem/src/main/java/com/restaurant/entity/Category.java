package com.restaurant.entity;

/**
 * This class implements category for menu representation.
 * It contains  is, name of particular category.
 * @author Tribel
 *
 */
public class Category {

	int id;
	String name;
	
	/**
	 * Constructs default instance.
	 */
	public Category() {
	}

	/**
	 * Constructs an {@link Category} instance with id and name.
	 * @param id of category.
	 * @param name {@link String} of new category.
	 */
	public Category(int id, String name) {
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
		return "Category [id=" + id + ", name=" + name + "]";
	};

}
