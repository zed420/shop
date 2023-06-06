package com.example.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.shop.entity.Category;
import com.example.shop.repository.CategoryRepository;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepository cr;
	
		
	public List<Category> getAllCategories(){
		return cr.findAll();
	}
	
	public Optional<Category> getCategoryById(Long id) {
		return cr.findById(id);
	}
	
	@Transactional
	public void removeById(Long catId) {
		cr.deleteById(catId);
	}
	
	//@Transactional
	//public Long updateById(String catName, Long catId) {
		//return cr. .updateById(catName, catId);
	//}

	@Transactional
	public Category saveCategories(Category cat) {
		return cr.save(cat);
	}
}

