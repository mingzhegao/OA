package com.turing.code.service;

import java.util.List;

import com.turing.code.entity.GONGCHENGLEIXING;
import com.turing.code.entity.SHANGPINLEIXING;

public interface IGongchengleixingService {
	public List<GONGCHENGLEIXING> querygclx();

	public void save(GONGCHENGLEIXING gclxs);

	public GONGCHENGLEIXING querySplxById(String id);

	public void edit(GONGCHENGLEIXING gclx);

	public void delete(String[] ids);
}
