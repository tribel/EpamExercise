package com.restaurant.entity;

/**
 *  This class implements dish entity for entire menu. 
 *  It contains id , name , price , and id of particular category.
 * @author Tribel
 *
 */
public class Menu {

	private int id;
	private double price;
	private String name;
	private int categoryId;

	/**
	 * Constructs default instance.
	 */
	public Menu() {
	}

	/**
	 * Constructs {@link Menu} instance with further parameters.
	 * @param id of the {@link Menu} entity.
	 * @param price of the particular dish.
	 * @param {@link String} name of the dish. 
	 * @param id of exact dish category.
	 */
	public Menu(int id, double price, String name, int categoryId) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.categoryId = categoryId;
	}
	
	/**
	 * Constructs {@link Menu} instance with further parameters.
	 * @param price of the particular dish.
	 * @param {@link String} name of the dish. 
	 * @param id of exact dish category.
	 */
	public Menu(double price, String name, int categoryId) {
		super();
		this.price = price;
		this.name = name;
		this.categoryId = categoryId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (categoryId != other.categoryId)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", price=" + price + ", name=" + name
				+ ", categoryId=" + categoryId + "]";
	}

}
