package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartproductId;
	private int quantity;
	private double amount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cartId")
	@JsonBackReference
	private Cart cart;
	
	@OneToOne(cascade = CascadeType.ALL)

	private Products products;
	
	@ManyToOne
	@JoinColumn(name="orderId")
	@JsonBackReference
	private MyOrder order;
	
	
}
