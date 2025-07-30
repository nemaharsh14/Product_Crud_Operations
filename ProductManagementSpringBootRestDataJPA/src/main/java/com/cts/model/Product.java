package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "products_info")
public class Product {
	@Id
	@Column(name = "pid", length = 3, nullable = false)
	@GeneratedValue
	private int productId;
	@Min(value=1000, message="Price cannot be less than 1000")
	@Max(value=100000, message="Price cannot be greater than 100000")
	private int productPrice;
	private String productName;
	@Size(min=6, max=15, message="message cannot be less than 6 and greater than 15")
	@NotEmpty(message="Catrgory cannot be empty")
	private String productCategory;



	public Product() {

	}

	public Product( int productPrice, String productName, String productCategory) {
		super();
	
		this.productPrice = productPrice;
		this.productName = productName;
		this.productCategory = productCategory;
	}

}
