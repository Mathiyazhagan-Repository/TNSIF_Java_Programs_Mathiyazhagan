//Program to demonstrate Online Shopping Application 
package application.pgm;

import java.util.Scanner;

import entities.pgm.Admin;
import entities.pgm.Customer;
import entities.pgm.Order;
import entities.pgm.Product;
import entities.pgm.ProductQuantityPair;
import services.pgm.AdminService;
import services.pgm.CustomerService;
import services.pgm.OrderService;
import services.pgm.ProductService;

public class OnlineShopping {
	private static ProductService productService = new ProductService();
	private static CustomerService customerService = new CustomerService();
	private static OrderService orderService = new OrderService();
	private static AdminService adminService = new AdminService();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1. Admin Menu");
			System.out.println("2. Customer Menu");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: //Admin Module
				int adminChoice;
				do {
					System.out.println("\nAdmin Menu:");
					System.out.println("1. Add Product");
					System.out.println("2. Remove Product");
					System.out.println("3. View Products");
					System.out.println("4. Create Admin");
					System.out.println("5. View Admins");
					System.out.println("6. Update Order Status");
					System.out.println("7. View Orders");
					System.out.println("8. Return");
					System.out.print("Choose an option: ");
					adminChoice = scanner.nextInt();

					switch (adminChoice) {
					case 1:
						addProduct(scanner);
						break;
					case 2:
						removeProduct(scanner);
						break;
					case 3:
						viewProducts();
						break;
					case 4:
						createAdmin(scanner);
						break;
					case 5:
						viewAdmins();
						break;
					case 6:
						updateOrderStatus(scanner);
						break;
					case 7:
						viewOrders();
						break;
					case 8:
						System.out.println("Exiting Admin...");
						break;
					default:
						System.out.println("Invalid choice! Please try again.");
					}
				} while (adminChoice != 8);
				break;

			case 2: //Customer Module
				int customerChoice;
				do {
					System.out.println("\nCustomer Menu:");
					System.out.println("1. Create Customer");
					System.out.println("2. View Customers");
					System.out.println("3. Place Order");
					System.out.println("4. View Orders");
					System.out.println("5. View Products");
					System.out.println("6. Return");
					System.out.print("Choose an option: ");
					customerChoice = scanner.nextInt();
					switch (customerChoice) {
					case 1:
						createCustomer(scanner);
						break;
					case 2:
						viewCustomers();
						break;
					case 3:
						placeOrder(scanner);
						break;
					case 4:
						viewOrders(scanner);
						break;
					case 5:
						viewProducts();
						break;
					case 6:
						System.out.println("Exiting Customer Menu...");
						break;
					default:
						System.out.println("Invalid choice! Please try again.");
					}
				} while (customerChoice != 6);
				break;
			case 3:
				System.out.println("Exiting...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}

	}

	private static void addProduct(Scanner scanner) {
		System.out.print("Enter Product ID: ");
		int productId = scanner.nextInt();
		System.out.print("Enter Product Name: ");
		String name = scanner.next();
		System.out.print("Enter Product Price: ");
		double price = scanner.nextDouble();
		System.out.print("Enter Stock Quantity: ");
		int stockQuantity = scanner.nextInt();

		Product product = new Product(productId, name, price, stockQuantity);
		productService.addProduct(product);
		System.out.println("Product added successfully!");
	}

	private static void removeProduct(Scanner scanner) {
		System.out.print("Enter Product ID: ");
		int productId = scanner.nextInt();

		productService.removeProduct(productId);
		System.out.println("Product removed successfully!");
	}

	private static void createAdmin(Scanner scanner) {
		System.out.print("Enter User ID: ");
		int userId = scanner.nextInt();
		System.out.print("Enter Username: ");
		String username = scanner.next();
		System.out.print("Enter Email: ");
		String email = scanner.next();

		Admin admin = new Admin(userId, username, email);
		adminService.addAdmin(admin);
		System.out.println("Admin created successfully!");
	}

	private static void viewAdmins() {
		System.out.println("Admins:");
		for (Admin admin : adminService.getAdmins()) {
			System.out.println("User ID: " + admin.getUserId() + ", Username: " + admin.getUsername() + ", Email: "
					+ admin.getEmail());
		}
	}

	private static void updateOrderStatus(Scanner scanner) {
		System.out.print("Enter Order ID: ");
		int orderId = scanner.nextInt();
		System.out.print("Enter new status (Completed/Delivered/Cancelled): ");
		String status = scanner.next();

		orderService.updateOrderStatus(orderId, status);

	}

	private static void viewOrders() {
		System.out.println("Orders:");
		for (Order order : orderService.getOrders()) {
			System.out.println("Order ID: " + order.getOrderId() + ", Customer: " + order.getCustomer().getUsername()
					+ ", Status: " + order.getStatus());
			for (ProductQuantityPair pair : order.getProducts()) {
				System.out.println("  Product: " + pair.getProduct().getName() + ", Quantity: " + pair.getQuantity());
			}
		}
	}

	private static void createCustomer(Scanner scanner) {
		System.out.print("Enter User ID: ");
		int userId = scanner.nextInt();
		System.out.print("Enter Username: ");
		String username = scanner.next();
		System.out.print("Enter Email: ");
		String email = scanner.next();
		System.out.print("Enter Address: ");
		String address = scanner.next();

		Customer customer = new Customer(userId, username, email, address);
		customerService.addCustomer(customer);
		System.out.println("Customer created successfully!");
	}

	private static void viewCustomers() {
		System.out.println("Customers:");
		for (Customer customer : customerService.getCustomers()) {
			System.out.println("User ID: " + customer.getUserId() + ", Username: " + customer.getUsername()
					+ ", Email: " + customer.getEmail() + ", Address: " + customer.getAddress());
		}
	}

	private static void placeOrder(Scanner scanner) {
		System.out.print("Enter Customer ID: ");
		int customerId = scanner.nextInt();
		Customer customer = customerService.getCustomer(customerId);

		if (customer == null) {
			System.out.println("Customer not found!");
			return;
		}

		Order order = new Order(orderService.getOrders().size() + 1, customer);

		while (true) {
			System.out.print("Enter Product ID to add to order (or -1 to complete): ");
			int productId = scanner.nextInt();
			if (productId == -1) {
				break;
			}

			Product product = productService.getProductById(productId);
			if (product == null) {
				System.out.println("Product not found!");
				continue;
			}

			System.out.print("Enter quantity: ");
			int quantity = scanner.nextInt();
			order.addProduct(product, quantity);
		}

		orderService.placeOrder(order);
		customer.addOrder(order);
		System.out.println("Order placed successfully!");
	}

	private static void viewOrders(Scanner scanner) {
		System.out.print("Enter Customer ID: ");
		int customerId = scanner.nextInt();
		Customer customer = customerService.getCustomer(customerId);

		if (customer == null) {
			System.out.println("Customer not found!");
			return;
		}

		System.out.println("Orders:");
		for (Order order : customer.getOrders()) {
			System.out.println("Order ID: " + order.getOrderId() + ", Status: " + order.getStatus());
			for (ProductQuantityPair pair : order.getProducts()) {
				System.out.println("  Product: " + pair.getProduct().getName() + ", Quantity: " + pair.getQuantity());
			}
		}
	}

	private static void viewProducts() {
		System.out.println("Products:");
		for (Product product : productService.getProducts()) {
			System.out.println(product);
		}
	}

}
