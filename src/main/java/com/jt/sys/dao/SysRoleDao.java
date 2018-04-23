package com.jt.sys.dao;
import com.jt.sys.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleDao {

     /**获取当前页的角色信息*/
	 public List<SysRole> findPageObjects(
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize,
	         @Param("name")String name);
	 
	 /**获取记录总数*/
	 public int getRowCount(@Param("name")String name);
	 //删除对象的方法
	 int deleteObject(Integer id);
	 
	 
}
