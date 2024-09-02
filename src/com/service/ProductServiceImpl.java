package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.Jdbc;
import com.model.Product;

public class ProductServiceImpl implements ProductService {

	// static List<Product> productList = new ArrayList<>();

	@Override
	public void addProduct(Product product) {
		try {
			String sql = "insert into product(name,company,price,mfDate,expDate)values('" + product.getName() + "','"
					+ product.getCompany() + "','" + product.getPrice() + "','" + product.getMfDate() + "','"
					+ product.getExDate() + "')";
			Statement st = Jdbc.connection().createStatement();
			st.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(int id) {
		try {
			String sql = "delete from product where id = ?";

			PreparedStatement ps = Jdbc.connection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getAllProduct() {
		try {
			String display = "select * from product";
			Statement st = Jdbc.connection().createStatement();
			ResultSet rs = st.executeQuery(display);
			System.out.println("=========================================================================================");
			System.out.println(" ID   |  Name           | Company       | Price         | MFDate        | ExpDate       |");
			System.out.println("=========================================================================================");
			while (rs.next()) {
				System.out.println( rs.getInt(1)+"     | "+rs.getString(2)+"       \t| "+ rs.getString(3)+"     \t| "+rs.getDouble(4)+"      \t| "+rs.getDate(5)+" \t| "+ rs.getDate(6)+"  \t|");
				System.out.println("-----------------------------------------------------------------------------------------");
//				System.out.println("Id = " + rs.getInt(1));
//				System.out.println("Name = " + rs.getString(2));
//				System.out.println("Company = " + rs.getString(3));
//				System.out.println("Price = " + rs.getDouble(4));
//				System.out.println("mfDate = " + rs.getDate(5));
//				System.out.println("expDate = " + rs.getDate(6));
//				System.out.println("-----------------------");
			}
			Jdbc.connection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Product product) {
		try {

			String sql = "update product set name = ?, company=? , price=? where id = ?";
			PreparedStatement ps = Jdbc.connection().prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getCompany());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getId());

			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Update Success");
			} else {
				System.out.println("Update Success");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
