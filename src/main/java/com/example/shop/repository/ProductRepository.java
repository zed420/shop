package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.shop.entity.Category;
import com.example.shop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findAll();
	Product findByProdId(Long prodId);
	List<Product> findByProdName(String prodName);
	
	//@Query("SELECT p FROM Products p WHERE p.cat.catId = ?1")
	List<Product> findByCat(Category cat);
	
	@Transactional
	@Modifying
	@Query("UPDATE Product p SET p.prodName = ?1 WHERE p.prodId = ?2")
	Integer updateProdNameById(String prodName, Long prodId);
	
	@Modifying
    @Query("DELETE FROM Product WHERE prodId = ?1")
	Integer removeById(Long prodId);
	
}
