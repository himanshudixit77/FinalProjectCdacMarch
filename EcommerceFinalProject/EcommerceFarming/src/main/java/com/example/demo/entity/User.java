package com.example.demo.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="user_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	
	@NotBlank(message="Enter the Name")
	private String userName;
	
	@Email
	private String email;
	
	@Length(min=3)
	private String password;
	private String imagePath;
	
	private long contactNumber;
	
	private int gstNo;
	private String companyName;
	private Date regisdate;
	
	@OneToOne(mappedBy = "user" ,cascade =  CascadeType.ALL)
	private Address address;
	
	/*@JsonIgnore
	@OneToMany(mappedBy = "userpro", cascade = CascadeType.ALL)
	private List<Products> product;*/
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonBackReference
	private Cart cart;

}
