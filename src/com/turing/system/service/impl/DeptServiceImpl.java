package com.turing.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.system.entity.SysDept;
import com.turing.system.entity.SysMenu;
import com.turing.system.mapper.SysDeptMapper;
import com.turing.system.service.IDeptService;

@Service
public class DeptServiceImpl implements IDeptService{

	@Autowired
	private SysDeptMapper deptMapper;
	
	@Override
	public List<SysDept> queryAllWithList() {
		List<SysDept> topDeptList = deptMapper.queryAllDeptByTop();
		List<SysDept> rvList = new ArrayList<SysDept>();
		for (SysDept sysDept : topDeptList) {
			SysDept rv = this.recursiveDeptByTopDept(sysDept);
			rvList.add(rv);
		}
		return rvList;
	}
	
	private SysDept recursiveDeptByTopDept(SysDept dept) {
		List<SysDept> childDepts = deptMapper.queryDeptByOne(dept);
		for (SysDept sysDept : childDepts) {
			SysDept m = recursiveDeptByTopDept(sysDept);
			dept.getDeptList().add(m);
		}
		return dept;
	}

	@Override
	public SysDept queryById(String id) {
		return deptMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(SysDept dept) {
		deptMapper.insertSelective(dept);
	}

	@Override
	public void update(SysDept dept) {
		deptMapper.updateByPrimaryKeySelective(dept);
	}

	@Override
	public void deleteById(String id) {
		deptMapper.deleteByPrimaryKey(id);
	}

}
