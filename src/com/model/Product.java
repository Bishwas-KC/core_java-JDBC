package com.model;

import java.time.LocalDate;

public class Product {

	private int id;
	private String name;
	private String company;
	private double price;
	private LocalDate mfDate;
	private LocalDate exDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getMfDate() {
		return mfDate;
	}

	public void setMfDate(LocalDate mfDate) {
		this.mfDate = mfDate;
	}

	public LocalDate getExDate() {
		return exDate;
	}

	public void setExDate(LocalDate exDate) {
		this.exDate = exDate;
	}

	@Override
	public String toString() {
		return "\n Product [id=" + id + ", name=" + name + ", company=" + company + ", price=" + price + ", mfDate="
				+ mfDate + ", exDate=" + exDate + "]";
	}
	

}
