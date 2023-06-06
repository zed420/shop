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
import com.example.shop.service.CategoryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService cs;

	@GetMapping
	public List<Category> getAllCategories() {
		return cs.getAllCategories();
	}

	@PostMapping("/add")
	public Category addCategory(@RequestBody Category cat) {
		return cs.saveCategories(cat);
	}

	@GetMapping("/get/{id}")
	public Optional<Category> getCatById(@PathVariable("id") Long id) {
		return cs.getCategoryById(id);
	}

	@DeleteMapping("/remove/{id}")
	public void deleteCategory(@PathVariable("id") Long id) {
		cs.removeById(id);
	}

	@PutMapping("/update/{id}")
	public Category updateCategory(@RequestBody Category cat, @PathVariable Long id) {

		return cs.getCategoryById(id).map(category -> {
			category.setCatName(cat.getCatName());
			category.setCatDes(cat.getCatDes());
			return cs.saveCategories(category);
		}).orElseGet(() -> {
			cat.setId(id);
			return cs.saveCategories(cat);
		});
	}

}
