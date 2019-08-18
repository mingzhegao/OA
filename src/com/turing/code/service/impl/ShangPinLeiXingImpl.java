package com.turing.code.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.SHANGPINLEIXING;
import com.turing.code.mapper.SHANGPINLEIXINGMapper;
import com.turing.code.service.IShangPinLeiXingService;
@Service
public class ShangPinLeiXingImpl implements IShangPinLeiXingService {
	@Autowired
	public SHANGPINLEIXINGMapper mapper;
	@Override
	public List<SHANGPINLEIXING> querySplx() {
		
		return mapper.queryAll();
	}
	@Override
	public void save(SHANGPINLEIXING splxs) {
		splxs.setCslId(UUID.randomUUID().toString());
		mapper.insert(splxs);
		
	}
	@Override
	public SHANGPINLEIXING querySplxById(String id) {
		
		return mapper.selectByPrimaryKey(id);
	}
	@Override
	public void edit(SHANGPINLEIXING splx) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKeySelective(splx);
	}
	@Override
	public void delete(String[] ids) {
		for(int i=0 ;i<ids.length;i++) {
		mapper.deleteByPrimaryKey(ids[i]);
		}
		
	}
		
}
