package com.jt.sys.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/5/21.
 */
public interface SysUserRoleDao {
    int insertObject(@Param("userId")Integer userId,
                     @Param("roleIds")String[] roleIds);
}
