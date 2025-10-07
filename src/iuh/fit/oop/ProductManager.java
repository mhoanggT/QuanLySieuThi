package iuh.fit.oop;

public class ProductManager {
	private Products[] products;
	private int size;
	
	public ProductManager() {
		products = new Products[5];
		size = 0;
	}
	
	public void ensureCapacity() {
		if(size == products.length) {
			Products[] newArr = new Products[products.length * 2];
			for (int i = 0; i < size; i++) {
				newArr[i] = products[i];
			}
			products = newArr;
		}
	}
	
	public void Add(Products newProduct) {
		ensureCapacity();
		products[size++] = newProduct;
	}
	
	public Products findById(String id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equalsIgnoreCase(id)) {
                return products[i];
            }
        }
        return null;
    }

    
    public boolean removeById(String id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equalsIgnoreCase(id)) {
                for (int j = i; j < size - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[--size] = null;
                return true;
            }
        }
        return false;
    }

    public void showAll() {
        if (size == 0) {
            System.out.println("No product is found");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
    }
}
