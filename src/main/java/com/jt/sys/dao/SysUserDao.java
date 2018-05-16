package com.jt.sys.dao;

import com.jt.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tedu on 2018/5/8.
 */
public interface SysUserDao {
    List<SysUser> findPageObjects(@Param("name") String name,
                                @Param("startIndex") Integer startIndex,
                                @Param("pageSize") Integer pageSize);
    int getRowCount(@Param("name") String name);
}
