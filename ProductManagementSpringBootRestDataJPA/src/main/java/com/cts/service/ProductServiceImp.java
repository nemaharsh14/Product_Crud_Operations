package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cts.exception.CategoryNotFound;
import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service("service")
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

	ProductRepository repo;

	@Override
	public String addProduct(Product product) {
		repo.save(product);
		return ("Product Saved Successfully");
	}

	@Override
	public String updateProduct(Product product) {
		repo.save(product);
		return ("Product Updated Successfully");
	}

	@Override
	public String deleteProductById(int productId) throws ProductNotFound {

		repo.delete(getProductById(productId));
		return ("Product Deleted Successfully");
	}

	@Override
	public Product getProductById (int productId) throws ProductNotFound {

		Optional<Product> optionalp = repo.findById(productId);
		if(optionalp.isEmpty()) {
			throw new ProductNotFound("Product Not Found with given Id");
		}
		return optionalp.get();
	}

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();

	}

	@Override
	public List<Product> getProductsByCategory(String productCategory) throws CategoryNotFound {
		List<Product> prod=repo.findByProductCategory(productCategory);
		if(prod.size()==0) {
			throw new CategoryNotFound("Category Not Found");
		}
		return prod;
	}

	@Override
	public List<Product> getProductsBetweenPriceRange(int intialPrice, int finalPrice) {

		return repo.findByProductPriceBetween(intialPrice, finalPrice);
	}

}
