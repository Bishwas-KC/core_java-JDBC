package com.view;

import java.time.LocalDate;
import java.util.Scanner;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class ProductTest {

	static Scanner scanner = new Scanner(System.in);
	static ProductService productService = new ProductServiceImpl();

	public static void main(String[] args) {

		boolean status = true;

		while (status) {
			System.out.println("-------------------------");
			System.out.println("|1. Add Data \t\t|");
			System.out.println("|2. Display Data \t|");
			System.out.println("|3. Delete Data \t|");
			System.out.println("|4. Update Data \t|");
			System.out.println("|5. exit \t\t|");
			System.out.println("-------------------------");
		int value = scanner.nextInt();

		switch (value) {
			case 1:
				addBtn();
				break;
			case 2:
				getAll();
				break;
			case 3:
				deleteBtn();
				break;
			case 4:
				updateBtn();
				break;
			case 5:
				status = false;
				break;
			default:
				System.out.println("Invalid Input");
			}
		}

	}

	static void addBtn() {
		char flag = 'y';
		do {
			Product product = new Product();

			System.out.println("Enter Id : ");
			product.setId(scanner.nextInt());

			System.out.println("Enter Name : ");
			product.setName(scanner.next());

			System.out.println("Enter Company : ");
			product.setCompany(scanner.next());

			System.out.println("Enter Price : ");
			product.setPrice(scanner.nextFloat());

			product.setMfDate(LocalDate.now());

			System.out.println("Enter ExpireDate : ");
			product.setExDate(LocalDate.now().plusYears(scanner.nextInt()));

			productService.addProduct(product);

			System.out.println("Do you Want More : (y/n)");
			flag = scanner.next().charAt(0);
		} while (flag == 'y');
	}

	static void getAll() {
		productService.getAllProduct();
	}

	static void deleteBtn() {
		System.out.println("Enter the id to Delete : ");
		productService.deleteProduct(scanner.nextInt());
	}
	static void updateBtn() {
		Product product = new Product();
		System.out.println("Enter the data id to Update : ");
		product.setId(scanner.nextInt());
		
		System.out.println("Enter the Product New Name : ");
		product.setName(scanner.next());
		
		System.out.println("Enter the Product New Company : ");
		product.setCompany(scanner.next());
		
		System.out.println("Enter the Product New Price : ");
		product.setPrice(scanner.nextDouble());
		
		productService.updateProduct(product);
	}

}
