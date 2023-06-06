package com.example.shop.entity;

import lombok.Data;

@Data
public class ProductDTO {
	
	private long prodId;
	private String prodName;
	private String prodDes;
	private int prodQunt;
	private String cat;
	
	public ProductDTO(long prodId, String prodName, String prodDes, int prodQunt, String cat) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodDes = prodDes;
		this.prodQunt = prodQunt;
		this.cat = cat;
	}
}
/*** Note: 
 * 
 * 'cat' is an object in Product entity but 
 * here to solve the problem I need to create it as a String
 */
 