package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tedu on 2018/5/8.
 */
public interface SysUserService {
    /**
     * 保存用户数据及用户和角色的关系数据
     * @param entity
     * @param roleIds
     * @return
     */
    int saveObject(SysUser entity,String roleIds);
    PageObject<SysUser> findPageObjects(String name, Integer pageCurrent);
    int doValidById(Integer id,Integer valid,String modifiedUser);
}
