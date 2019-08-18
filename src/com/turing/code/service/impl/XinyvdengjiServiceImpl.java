package com.turing.code.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.service.IXinyvdengjiService;

@Service
public class XinyvdengjiServiceImpl implements IXinyvdengjiService{

	@Autowired
	private CodeXinyvdengjiMapper xydjMapper;
	@Override
	public List<CodeXinyvdengji> queryAll() {
		return xydjMapper.queryAll();
	}
	@Override
	public CodeXinyvdengji queryById(String id) {
		return xydjMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			xydjMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeXinyvdengji xydj) {
		xydj.setCxyId(UUID.randomUUID().toString());
		xydjMapper.insertSelective(xydj);
	}
	@Override
	public void edit(CodeXinyvdengji xydj) {
		xydjMapper.updateByPrimaryKeySelective(xydj);
	}

}
