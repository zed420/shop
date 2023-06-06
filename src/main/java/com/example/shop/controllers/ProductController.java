package com.example.shop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.entity.Category;
import com.example.shop.entity.Product;
import com.example.shop.entity.ProductDTO;
import com.example.shop.service.CategoryService;
import com.example.shop.service.ProductService;

@RestController
@RequestMapping("/prods")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	@Autowired
	ProductService ps;

	@Autowired
	CategoryService cs;

	@GetMapping
	public List<Product> getAllProds() {
		return ps.getAllProducts();
	}

	@GetMapping("/get/{id}")
	public Optional<Product> getById(@PathVariable("id") Long id) {
		return ps.getProdById(id);
	}

	@PostMapping("/add")
	public Product addProd(@RequestBody ProductDTO prodDTO) {

		Long catId = Long.parseLong(prodDTO.getCat()); // should be validated before
		Optional<Category> cat = cs.getCategoryById(catId);
		Product prod = new Product();
		prod.setProdName(prodDTO.getProdName());
		prod.setProdDes(prodDTO.getProdDes());
		prod.setProdQunt(prodDTO.getProdQunt()); // should be validated before
		prod.setCat(cat.get());
		return ps.saveProd(prod);
	}

	@DeleteMapping("/remove/{id}")
	public void removeById(@PathVariable("id") Long id) {
		ps.removeById(id);
	}

	@PutMapping("/update/{id}")
	public Optional<Product> updateProduct(@RequestBody ProductDTO prodDTO, @PathVariable Long id) {

		return ps.getProdById(id).map(product -> {
			
			Long catId = Long.parseLong(prodDTO.getCat()); // should be validated before
			Optional<Category> cat = cs.getCategoryById(catId);
			
			product.setProdName(prodDTO.getProdName());
			product.setProdDes(prodDTO.getProdDes());
			product.setProdQunt(prodDTO.getProdQunt());
			product.setCat(cat.get());
			return ps.saveProd(product);
		});
	}
}
