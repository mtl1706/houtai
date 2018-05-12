package com.jt.sys.service.impl;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysRoleDao;
import com.jt.sys.entity.SysRole;
import com.jt.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;

	@Override
	public PageObject<SysRole> findPageObjects(Integer pageCurrent, String name) {
		//1.参数合法性验证
		if (pageCurrent == null || pageCurrent < 1)
			throw new ServiceException("参数异常,pageCurrent=" + pageCurrent);
		//2.查询当前页的角色信息
		int pageSize = 2;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<SysRole> records =
				sysRoleDao.findPageObjects(startIndex, pageSize, name);
		//3.查询总记录数
		int rowCount = sysRoleDao.getRowCount(name);
		//4.对数据进行封装
		PageObject<SysRole> pObject =
				new PageObject<>();
		pObject.setRecords(records);
		pObject.setRowCount(rowCount);
		pObject.setPageCurrent(pageCurrent);
		pObject.setPageSize(pageSize);
		System.out.println("pageObject" + pObject);
		System.out.println("records=" + records);
		return pObject;
	}

	@Override
	public int deleteObject(Integer id) {
		if(id==null||id<1)
			throw new ServiceException("删除id值不合法");
		//2.执行dao操作
		//2.1查找用户角色关系表,看是否有此角色对应的关系数据
		//2.2查询角色菜单关系表,看是否有此角色对应的关系数据
		//2.3假如不存在关系数据,则可以直接删除
		int row = sysRoleDao.deleteObject(id);
		if(row==0)
			throw new ServiceException("数据可能已经不存在");
		return row;
	}

	@Override
	public int saveObject(SysRole entity) {
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
		int rows = sysRoleDao.insertObject(entity);
		return rows;
	}

	@Override
	public int updateObject(SysRole entity) {
		//1.合法性验证
		//2.进行修改
		//3.验证结果
		//4.返回结果
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
		int rows = sysRoleDao.updateObject(entity);
		if(rows==0)
			throw new ServiceException("数据可能已经不存在");
		return rows;
	}

}
