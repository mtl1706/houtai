package com.jt.sys.service;

import com.jt.common.vo.CheckBox;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysRole;

import java.util.List;

public interface SysRoleService {
    List<CheckBox> findObjects();
	/**定义一个方法，实现分页查询*/
	PageObject<SysRole> findPageObjects(Integer pageCurrent,String name);
	//删除
	int deleteObject(Integer id);
	//保存角色信息
	int saveObject(SysRole entity);
	//修改角色
	int updateObject(SysRole entity);
}
