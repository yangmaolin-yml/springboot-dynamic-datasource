package com.example.demo.mapper.master;

import java.util.List;

import com.example.demo.pojo.master.Animal;

public interface MasterMapper {
	
	int insert(Animal animal);
	
	List<Animal> select(Integer id);
	
	int update (Animal animal);
	
	int delete(Integer id);
}
