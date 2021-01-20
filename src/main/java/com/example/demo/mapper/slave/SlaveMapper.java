package com.example.demo.mapper.slave;

import java.util.List;

import com.example.demo.pojo.slave.Plant;

public interface SlaveMapper {
	
	int insert(Plant plant);
	
	List<Plant> select(Integer id);
	
	int update (Plant plant);
	
	int delete(Integer id);
}
