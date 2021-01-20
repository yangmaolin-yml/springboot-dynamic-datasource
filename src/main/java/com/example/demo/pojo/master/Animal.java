package com.example.demo.pojo.master;

import java.io.Serializable;

import lombok.Data;

@Data
public class Animal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 658766047237833172L;

	private Integer id;
	
	private String name;


	
	
}
