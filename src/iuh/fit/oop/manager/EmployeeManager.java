package iuh.fit.oop.manager;

import iuh.fit.oop.entity.Employee;

public class EmployeeManager {
	private Employee[] employees;
	private int size;
	
	public EmployeeManager() {
		employees = new Employee[5];
		size = 0;
	}
	
	public void ensureCapacity() {
		if(size == employees.length) {
			Employee[] newArr = new Employee[employees.length * 2];
			for (int i = 0; i < size; i++) {
				newArr[i] = employees[i];
			}
			employees = newArr;
		}
	}
	
	public void Add(Employee newEmployees) {
		ensureCapacity();
		employees[size++] = newEmployees;
	}
	
	public Employee findById(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId().equalsIgnoreCase(id)) {
                return employees[i];
            }
        }
        return null;
    }
    
    public boolean removeById(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId().equalsIgnoreCase(id)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return true;
            }
        }
        return false;
    }

    public void showAll() {
        if (size == 0) {
            System.out.println("No employees is found");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
}
