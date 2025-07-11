//Program to define ProductQuantityPair class
package entities.pgm;

public class ProductQuantityPair {
	private Product product;
	private int quantity;

	public ProductQuantityPair(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	// Getters and setters
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
