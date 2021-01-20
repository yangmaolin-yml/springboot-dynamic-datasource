package com.example.demo.pojo.slave;

import java.io.Serializable;
import lombok.Data;


@Data
public class Plant implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6194022717801501226L;

	private Integer id;
	
	private String name;
}
