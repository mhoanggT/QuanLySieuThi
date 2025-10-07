package iuh.fit.oop.manager;

import iuh.fit.oop.entity.Customer;

public class CustomerManager {
	private Customer[] customer;
	private int size;
	
	public CustomerManager() {
		customer = new Customer[5];
		size = 0;
	}
	
	public void ensureCapacity() {
		if(size == customer.length) {
			Customer[] newArr = new Customer[customer.length * 2];
			for (int i = 0; i < size; i++) {
				newArr[i] = customer[i];
			}
			customer = newArr;
		}
	}
	
	public void Add(Customer newCustomer) {
		ensureCapacity();
		customer[size++] = newCustomer;
	}
	
	public Customer findById(String id) {
        for (int i = 0; i < size; i++) {
            if (customer[i].getId().equalsIgnoreCase(id)) {
                return customer[i];
            }
        }
        return null;
    }
    
    public boolean removeById(String id) {
        for (int i = 0; i < size; i++) {
            if (customer[i].getId().equalsIgnoreCase(id)) {
                for (int j = i; j < size - 1; j++) {
                    customer[j] = customer[j + 1];
                }
                customer[--size] = null;
                return true;
            }
        }
        return false;
    }

    public void showAll() {
        if (size == 0) {
            System.out.println("No customer is found");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(customer[i]);
        }
    }
}
