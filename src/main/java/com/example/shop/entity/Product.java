package com.example.shop.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long prodId;
	private String prodName;
	private String prodDes;
	private int prodQunt;
	private Date createdDate = new Date();

	public Product() {}
	
	@ManyToOne(fetch = FetchType.EAGER)
    //@JsonManagedReference // To prevent the repeated data keeps on appearing
	@JoinColumn(name = "catId")
	private Category cat;
}
