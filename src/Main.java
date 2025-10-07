import java.time.LocalDate;
import java.util.Scanner;

import iuh.fit.oop.manager.*;
import iuh.fit.oop.entity.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        CustomerManager customerManager = new CustomerManager();
        EmployeeManager employeeManager = new EmployeeManager();

        int choice;
        do {
            System.out.println("\n===== QUAN LY SIEU THI =====");
            System.out.println("1. Quan ly San pham");
            System.out.println("2. Quan ly Khach hang");
            System.out.println("3. Quan ly Nhan vien");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> menuProduct(sc, productManager);
                case 2 -> menuCustomer(sc, customerManager);
                case 3 -> menuEmployee(sc, employeeManager);
                case 0 -> System.out.println("Tam biet!");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    private static void menuProduct(Scanner sc, ProductManager manager) {
        int choice;
        do {
            System.out.println("\n--- Quan ly San pham ---");
            System.out.println("1. Them san pham");
            System.out.println("2. Xoa san pham");
            System.out.println("3. Tim kiem theo ID");
            System.out.println("4. Hien thi tat ca");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Ten: "); String name = sc.nextLine();
                    System.out.print("Gia: "); double price = sc.nextDouble(); sc.nextLine();
                    System.out.print("So Luong: "); int quantity = sc.nextInt(); sc.nextLine();
                    System.out.print("Loai san pham: "); ProductType type = ProductType.valueOf(sc.nextLine()); sc.nextLine();
                    manager.Add(new Product(id, name, price,quantity,type));
                }
                case 2 -> {
                    System.out.print("Nhap ID can xoa: "); String id = sc.nextLine();
                    manager.removeById(id);
                }
                case 3 -> {
                    System.out.print("Nhap ID can tim: "); String id = sc.nextLine();
                    Product p = manager.findById(id);
                    System.out.println(p != null ? p : "Khong tim thay!");
                }
                case 4 -> manager.showAll();
            }
        } while (choice != 0);
    }

    private static void menuCustomer(Scanner sc, CustomerManager manager) {
        int choice;
        do {
            System.out.println("\n--- Quan ly Khach hang ---");
            System.out.println("1. Them khach hang");
            System.out.println("2. Xoa khach hang");
            System.out.println("3. Tim kiem theo ID");
            System.out.println("4. Hien thi tat ca");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Ten: "); String name = sc.nextLine();
                    System.out.print("SDT: "); String phone = sc.nextLine();
                    System.out.print("Gioi Tinh: "); Gender gender = Gender.valueOf(sc.nextLine()); sc.nextLine();
                    System.out.print("Ngay Sinh: "); LocalDate birthday = LocalDate.parse(sc.nextLine());
                    manager.Add(new Customer(id, name, gender, phone, birthday));
                }
                case 2 -> {
                    System.out.print("Nhap ID can xoa: "); String id = sc.nextLine();
                    manager.removeById(id);
                }
                case 3 -> {
                    System.out.print("Nhap ID can tim: "); String id = sc.nextLine();
                    Customer c = manager.findById(id);
                    System.out.println(c != null ? c : "Khong tim thay!");
                }
                case 4 -> manager.showAll();
            }
        } while (choice != 0);
    }

    private static void menuEmployee(Scanner sc, EmployeeManager manager) {
        int choice;
        do {
            System.out.println("\n--- Quan ly Nhan vien ---");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Tim kiem theo ID");
            System.out.println("4. Hien thi tat ca");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Ten: "); String name = sc.nextLine();
                    System.out.print("Chuc vu: "); Role role = Role.valueOf(sc.nextLine()); sc.nextLine();
                    System.out.print("Gioi Tinh: "); Gender gender = Gender.valueOf(sc.nextLine()); sc.nextLine();
                    manager.Add(new Employee(id, name, role, gender));
                }
                case 2 -> {
                    System.out.print("Nhap ID can xoa: "); String id = sc.nextLine();
                    manager.removeById(id);
                }
                case 3 -> {
                    System.out.print("Nhap ID can tim: "); String id = sc.nextLine();
                    Employee e = manager.findById(id);
                    System.out.println(e != null ? e : "Khong tim thay!");
                }
                case 4 -> manager.showAll();
            }
        } while (choice != 0);
    }
	}