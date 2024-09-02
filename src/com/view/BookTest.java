package com.view;

import java.util.Scanner;

import com.model.Book;
import com.service.BookService;
import com.service.BookServiceImpl;

public class BookTest {

	static BookService bookService = new BookServiceImpl();
	static Scanner scanner = new Scanner(System.in);

	static void addBtn() {
		char c = 'y';
		do {
			Book book = new Book();
			System.out.println("Enter the Book Isbn : ");
			book.setIsbn(scanner.nextInt());

			System.out.println("Enter the Book Title : ");
			book.setTitle(scanner.next());

			System.out.println("Enter the Book Author : ");
			book.setAuthor(scanner.next());
			
			System.out.println("Enter the Book Publisher : ");
			book.setPublisher(scanner.next());

			System.out.println("Enter the Book Price : ");
			book.setPrice(scanner.nextDouble());
			bookService.addBook(book);

			System.out.println("You want more to add(y/n)");
			c = scanner.next().charAt(0);
		} while (c == 'y');
	}

	static void updateBtn() {
		
		Book book = new Book();
		
		System.out.println("Enter the Book Isbn : ");
		String changeIsbn = scanner.next();

		System.out.println("Enter the Book Title : ");
		book.setTitle(scanner.next());

		System.out.println("Enter the Book Author : ");
		book.setAuthor(scanner.next());
		
		System.out.println("Enter the Book Publisher : ");
		book.setPublisher(scanner.next());

		System.out.println("Enter the Book Price : ");
		book.setPrice(scanner.nextDouble());

		bookService.updateBook(changeIsbn, book);
	}
	static void deleteBtn() {
		System.out.println("Enter the Book ISBN : ");
		bookService.deleteBook(scanner.next());
	}

	public static void main(String[] args) {
		
		boolean status = true;
		while(status) {
			
		System.out.println("1. Add Book");
		System.out.println("2. Delete Book");
		System.out.println("3. Update Book");
		System.out.println("4. GetAll Book");
		System.out.println("5. Exit");
		switch(scanner.nextInt()) {
		case 1 :
			addBtn();
			break;
		case 2 :
			deleteBtn();
			break;
		case 3 :
			updateBtn();
			break;
		case 4 :
			bookService.getAllBook();
			break;
		case 5 :
			status = false;
			break;
			default :
				System.out.println("invalid Input");
		}

		}
	}

}
