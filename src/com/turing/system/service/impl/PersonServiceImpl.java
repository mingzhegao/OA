package com.turing.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.turing.framework.util.FileUtils;
import com.turing.system.entity.SysDept;
import com.turing.system.entity.SysPerson;
import com.turing.system.entity.SysPost;
import com.turing.system.entity.SysUser;
import com.turing.system.mapper.SysDeptMapper;
import com.turing.system.mapper.SysPersonMapper;
import com.turing.system.mapper.SysPostMapper;
import com.turing.system.mapper.SysUserMapper;
import com.turing.system.page.PersonPage;
import com.turing.system.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService{

	@Autowired
	private SysPersonMapper personMapper;
	
	@Autowired
	private SysDeptMapper deptMapper;
	
	@Autowired
	private SysPostMapper spMapper;
	
	@Autowired
	private SysUserMapper userMapper;

	@Override
	public SysPerson queryById(String id) {
		return personMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(String[] ids,HttpServletRequest request) {
		for (int i = 0; i < ids.length; i++) {
			//删除图片
			SysPerson pp = personMapper.selectByPrimaryKey(ids[i]);
			FileUtils.deleteFileByUrl(pp.getPpPic(), request);
			
			personMapper.deleteByPrimaryKey(ids[i]);
		}
	}

	@Override
	public void save(SysPerson person,HttpServletRequest request,CommonsMultipartFile picFile) {
		
		String fileUrl = FileUtils.saveFile(picFile, request);
		person.setPpPic(fileUrl);
		person.setPpId(UUID.randomUUID().toString());
		person.setPpState("A");
		personMapper.insertSelective(person);
	}

	@Override
	public void update(SysPerson person, HttpServletRequest request, CommonsMultipartFile picFile) {
		if(picFile!=null && !picFile.isEmpty()){
			//删除原图片
			SysPerson pp = personMapper.selectByPrimaryKey(person.getPpId());
			FileUtils.deleteFileByUrl(pp.getPpPic(), request);
			//保存新图片
			String fileUrl = FileUtils.saveFile(picFile, request);
			person.setPpPic(fileUrl);
		}
		personMapper.updateByPrimaryKeySelective(person);
	}

	@Override
	public List<SysDept> queryDept() {
		return deptMapper.selectAll();
	}

	@Override
	public List<SysPost> querySpByDeptId(String deptId) {
		SysPost sp = new SysPost();
		sp.setDeptId(deptId);
		return spMapper.selective(sp);
	}

	@Override
	public List<SysUser> queryUnconnectedUser() {
		List<SysPerson> ppList = personMapper.queryAll(new PersonPage());
		List list = new ArrayList();
		for (SysPerson pp : ppList) {
			if(pp.getUserId()!=null){
				list.add(pp.getUserId());
			}
		}
		
		if(list.size()==0){
			list = null;
		}
		
		List<SysUser> userList = userMapper.selectNotInIds(list);
		return userList;
	}

	@Override
	public SysPerson queryAllInfoById(String ppId) {
		return personMapper.queryAllInfoById(ppId);
	}

	@Override
	public void updateUserIdToNull(String ppId) {
		personMapper.updateUserIdToNull(ppId);
	}

	@Override
	public void saveUser(SysUser user) {
		userMapper.insertSelective(user);
	}

	@Override
	public void queryForPage(PersonPage page) {
		//查询分页数据
		page.setList( personMapper.queryForPage(page) );
		//查询总记录数
		page.setRowCount( this.queryForCount(page) );
		//计算一共分几页
		if (page.getRowCount() % page.getPageSize() == 0) {
			page.setPageCount(  page.getRowCount() / page.getPageSize() );
		} else {
			page.setPageCount(  page.getRowCount() / page.getPageSize() + 1 );
		}
	}

	@Override
	public int queryForCount(PersonPage page) {
		return personMapper.queryForCount(page);
	}

}
