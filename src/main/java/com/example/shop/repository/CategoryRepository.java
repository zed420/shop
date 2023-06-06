package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.shop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	//void deleteById(Long id);
	
	List<Category> findAll();
	//Category findByCatId(Long catId);
	Category findByCatName(String catName);
	
	/*@Modifying
    @Query("DELETE FROM Category WHERE catId = ?1")
	void removeById(Long catId);*/
	
	/*@Transactional
	@Modifying
    @Query("UPDATE Category SET catName = ?1 WHERE catId = ?2")
	Long updateById(String catName, Long catId);*/
	
}
