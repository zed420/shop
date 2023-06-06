package com.example.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.shop.entity.Category;
import com.example.shop.entity.Product;
import com.example.shop.entity.ProductDTO;
import com.example.shop.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository pr;
	
	public List<Product> getAllProducts(){
		return pr.findAll();
	}
	
	public Product saveProd(Product product) {
		return pr.save(product);
	}
	
	public Optional<Product> getProdById(Long prodId) {
		return pr.findById(prodId);
	}
	
	public List<Product> getProdByCat(Category cat){
		return pr.findByCat(cat);
	}
	
	//public Integer updateProdName(String name, Integer id) {
	//	return pr.updateProdNameById(name, id);
	//}
	
	@Transactional
	public void removeById(Long id) {
		pr.deleteById(id);
	}
	
}

