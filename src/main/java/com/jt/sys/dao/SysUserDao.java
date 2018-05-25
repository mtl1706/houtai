package com.jt.sys.dao;

import com.jt.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tedu on 2018/5/8.
 */
public interface SysUserDao {
    //向表中插入数据
    int insertObjects(SysUser entity);
    List<SysUser> findPageObjects(@Param("name") String name,
                                @Param("startIndex") Integer startIndex,
                                @Param("pageSize") Integer pageSize);
    int getRowCount(@Param("name") String name);
    int doValidById(@Param("id")Integer id,@Param("valid")Integer valid,@Param("modifiedUser")String modifiedUser);

}
