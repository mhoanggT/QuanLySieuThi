package iuh.fit.oop;

public class Product {
	private String id;
	private String name;
	private double price;
	private int quantity;
	private ProductType type;
	
	public Product() {
	}

	public Product(String id, String name, double price, int quantity, ProductType type) {
		setId(id);
		setName(name);
		setPrice(price);
		setQuantity(quantity);
		setType(type);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(id == null || id.isEmpty()) {
			throw new IllegalArgumentException("Product's id must not be empty");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name must not be empty");
		}
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price <= 0) {
			throw new IllegalArgumentException("price must be greater than 0");
		}
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity < 0) {
			throw new IllegalArgumentException("quantity must not be less than 0");
		}
		this.quantity = quantity;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		if(type == null) {
			throw new IllegalArgumentException("invalid product type");
		}
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("| %10s | %20s | %10f | %10d | %10s |",
				id,
				name,
				price,
				quantity,
				type);
	}
}
