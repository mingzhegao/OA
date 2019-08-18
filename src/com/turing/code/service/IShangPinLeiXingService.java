package com.turing.code.service;

import java.util.List;

import com.turing.code.entity.SHANGPINLEIXING;

public interface IShangPinLeiXingService {
	public List<SHANGPINLEIXING> querySplx();

	public void save(SHANGPINLEIXING splxs);

	public SHANGPINLEIXING querySplxById(String id);

	public void edit(SHANGPINLEIXING splx);

	public void delete(String[] ids);
}
