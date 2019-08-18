package com.turing.code.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.GONGCHENGLEIXING;
import com.turing.code.entity.SHANGPINLEIXING;
import com.turing.code.mapper.GONGCHENGLEIXINGMapper;
import com.turing.code.service.IGongchengleixingService;
@Service
public class GongChengLeiXingImpl implements IGongchengleixingService {
	@Autowired
	private GONGCHENGLEIXINGMapper mapper;
	
	@Override
	public List<GONGCHENGLEIXING> querygclx() {
		return mapper.queryAll();
	}

	@Override
	public void save(GONGCHENGLEIXING gclxs) {
		gclxs.setCglId(UUID.randomUUID().toString());
		mapper.insert(gclxs);

	}

	@Override
	public GONGCHENGLEIXING querySplxById(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void edit(GONGCHENGLEIXING gclx) {
		mapper.updateByPrimaryKeySelective(gclx);

	}

	@Override
	public void delete(String[] ids) {
		for(int i=0 ;i<ids.length;i++) {
			mapper.deleteByPrimaryKey(ids[i]);
			}
	}

}
