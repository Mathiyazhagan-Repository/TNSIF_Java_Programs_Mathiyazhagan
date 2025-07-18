//Program to define ShoppingCart class
package entities.pgm;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	private Map<Product, Integer> items;

	public ShoppingCart() {
		this.items = new HashMap<>();
	}

	// Getters and setters
	public Map<Product, Integer> getItems() {
		return items;
	}

	public void addItem(Product product, int quantity) {
		items.put(product, quantity);
	}

	public void removeItem(Product product) {
		items.remove(product);
	}

	@Override
	public String toString() {
		return "ShoppingCart [items=" + items + "]";
	}
}
