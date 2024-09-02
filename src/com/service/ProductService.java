package com.service;


import com.model.Product;

public interface ProductService {

	void addProduct(Product pd);

	void deleteProduct(int id);
	
	void updateProduct(Product product);

	void getAllProduct();
}
