package com.manish.CRUDoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.manish.CRUDoperation.DTO.ProductDTO;
import com.manish.CRUDoperation.Entity.Product;
import com.manish.CRUDoperation.Service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		List<Product> products = productService.getAllProductsPaginated(page, size);
		return ResponseEntity.ok(products);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
		ProductDTO productDTO = productService.getProductDTOById(id);
		if (productDTO != null) {
			return ResponseEntity.ok(productDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product createdProduct = productService.createProduct(product);
		return ResponseEntity.ok(createdProduct);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		product.setId(id);
		Product updatedProduct = productService.updateProduct(product);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}

}
