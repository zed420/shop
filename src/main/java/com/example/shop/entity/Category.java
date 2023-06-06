package com.example.shop.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String catName;
	private String catDes;
	private Date createdDate = new Date(); 
	
	public Category() {}
	public Category(String catId) {}
	
	
	@OneToMany(mappedBy = "cat", orphanRemoval = true, cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Product> prolist;

}
