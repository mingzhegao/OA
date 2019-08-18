package com.turing.system.service;

import java.util.List;

import com.turing.system.entity.SysDept;

public interface IDeptService {
	
	List<SysDept> queryAllWithList();

	SysDept queryById(String id);

	void save(SysDept dept);

	void update(SysDept dept);

	void deleteById(String id);

}
