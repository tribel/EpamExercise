package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for storage all customer product and calculating sum 
 * @author Tribel
 *
 */
public class CustomerCart {

	private List<Product> productsList;

	public CustomerCart() {
		productsList = new ArrayList<>();
	}
	
	/**
	 * Constructor 
	 * @param productsList {@link List} of {@link Product}
	 */
	public CustomerCart(List<Product> productsList) {
		super();
		this.productsList = productsList;
	}

	/**
	 * Adding {@link Product} entity to the list
	 * @param product entity that will be added
	 */
	public void addProduct(Product product) {
		this.productsList.add(product);
	}
	
	public List<Product> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}

	public double totalOrderPeice() {
		return productsList.stream().mapToDouble(x -> x.getPrice()).sum();
	}
	
	
	
	
	
}
