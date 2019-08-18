package com.turing.system.mapper;

import java.util.List;


import com.turing.system.entity.SysPerson;
import com.turing.system.page.PersonPage;

public interface SysPersonMapper {
    int deleteByPrimaryKey(String ppId);

    int insert(SysPerson record);

    int insertSelective(SysPerson record);

    SysPerson selectByPrimaryKey(String ppId);

    int updateByPrimaryKeySelective(SysPerson record);

    int updateByPrimaryKey(SysPerson record);
    
    /**
     * 对人员进行条件查询
     * @param pp
     * @return
     */
	List<SysPerson> selective(SysPerson pp);

	List<SysPerson> queryAll(PersonPage page);
	/**
	 * 查询人员的信息，包括用户名，职务名及部门名
	 * @param ppId
	 * @return
	 */
	SysPerson queryAllInfoById(String ppId);
	/**
	 * 根据人员主键取消关联的用户
	 * @param ppId
	 */
	void updateUserIdToNull(String ppId);

	List<SysPerson> queryForPage(PersonPage page);

	int queryForCount(PersonPage page);
}