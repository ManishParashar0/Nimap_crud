package com.manish.CRUDoperation.DTO;

import com.manish.CRUDoperation.Entity.Category;

public class ProductDTO {
	private Long id;
	private String name;
	private double price;
	private CategoryDTO categoryDTO;

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(Long id, String name, double price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryDTO = categoryDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CategoryDTO getCategory() {
		return categoryDTO;
	}

	public void setCategory(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

}
