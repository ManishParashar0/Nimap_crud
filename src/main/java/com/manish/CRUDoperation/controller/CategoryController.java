package com.manish.CRUDoperation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manish.CRUDoperation.Entity.Category;
import com.manish.CRUDoperation.Entity.Product;
import com.manish.CRUDoperation.Service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> categories = categoryService.getAllCategories();
		return ResponseEntity.ok(categories);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
		Optional<Category> category = categoryService.getCategoryById(id);
		return category.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		Category createdCategory = categoryService.createCategory(category);
		return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
		category.setId(id);
		Category updatedCategory = categoryService.updateCategory(category);
		return ResponseEntity.ok(updatedCategory);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{categoryId}/products")
	public ResponseEntity<Product> addProductToCategory(@PathVariable Long categoryId, @RequestBody Product product) {
		Product createdProduct = categoryService.addProductToCategory(categoryId, product);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}

	@GetMapping("/{categoryId}/products")
	public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Long categoryId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		List<Product> products = categoryService.getProductsByCategoryId(categoryId, page, size);
		return ResponseEntity.ok(products);
	}

}
