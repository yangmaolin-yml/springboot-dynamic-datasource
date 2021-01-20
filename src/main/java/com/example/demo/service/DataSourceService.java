package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.DataSource;
import com.example.demo.common.DataSourceName;
import com.example.demo.mapper.master.MasterMapper;
import com.example.demo.mapper.slave.SlaveMapper;
import com.example.demo.pojo.master.Animal;
import com.example.demo.pojo.slave.Plant;

@Service
public class DataSourceService {
	
	@Autowired
	private MasterMapper masterMapper;
	@Autowired
	private SlaveMapper slaveMapper;
	
	@DataSource(name=DataSourceName.master)
	public List<Animal> Master(Integer id) {
		List<Animal> list = masterMapper.select(id);
		return list;
	}
	
	@DataSource(name=DataSourceName.slave)
	public List<Plant> Slave(Integer id) {
		List<Plant> list = slaveMapper.select(id);
		return list;
	}


}
