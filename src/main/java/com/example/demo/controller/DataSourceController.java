package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.DataSourceService;

@Controller
public class DataSourceController {
	
	@Autowired
	private DataSourceService sevice;
	
	@RequestMapping("/master")
	@ResponseBody
	public Object master(Integer id) {
		return sevice.Master(id);
	}
	
	@RequestMapping("/slave")
	@ResponseBody
	public Object slave(Integer id) {
		return sevice.Slave(id);
	}
}
