package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.Jdbc;
import com.model.Book;

public class BookServiceImpl implements BookService {

	@Override
	public void addBook(Book book) {
		try {
			String sql = "insert into book(isbn,title,author,publisher,price)values('" + book.getIsbn() + "','"
					+ book.getTitle() + "','" + book.getAuthor() + "','" + book.getPublisher() + "','" + book.getPrice()
					+ "')";
			Statement ps = Jdbc.connection().createStatement();
			ps.execute(sql);
			System.out.println("Insert Success!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBook(String isbn) {
		try {
			String sql = "delete from book where isbn =?";
			PreparedStatement st = Jdbc.connection().prepareStatement(sql);
			st.setString(1, isbn);
			st.execute();
			System.out.println("Success Delete!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(String isbn, Book book) {
		try {

			String sql = "update book set title=?,author=?,publisher=?,price=? where isbn=?";
			PreparedStatement ps = Jdbc.connection().prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPublisher());
			ps.setDouble(4, book.getPrice());

			ps.setString(5, isbn);
			int v = ps.executeUpdate();

			if (v == 1) {
				System.out.println("Update Success!!");
			} else {
				System.out.println("update failed!!");
			}
			Jdbc.connection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getAllBook() {
		try {
			String sql = "select * from book";
			PreparedStatement ps = Jdbc.connection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("-------------------------------------");
				System.out.println("Book ISBN : " + rs.getString("isbn"));
				System.out.println("Book title : " + rs.getString("title"));
				System.out.println("Book author : " + rs.getString("author"));
				System.out.println("Book publisher : " + rs.getString("publisher"));
				System.out.println("Book price : " + rs.getDouble("price"));
				System.out.println("-------------------------------------");
			}
			Jdbc.connection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
