/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: SysUserServiceImpl
 * Author:   tedu
 * Date:     2018/5/8 16:37
 * Description:
 * History:
 * <author>          <time&date>          <version>          <desc>
 * 作者姓名           修改时间             版本号             描述
 */
package com.jt.sys.service.impl;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysUser;
import com.jt.sys.service.SysUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author tedu
 * @create 2018/5/8
 * @since 1.0.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override//用户用户信息以及用户角色的关系数据
    public int saveObject(SysUser entity, String roleIds) {
        if(entity==null)throw new ServiceException("对象不能为空");
        if(StringUtils.isEmpty(entity.getUsername()))
            throw new ServiceException("用户名不能为空");
        if(StringUtils.isEmpty(roleIds))
            throw new ServiceException("必须为用户分配角色");
         //对用户密码加密 此处用的是shiro中的加密方法
        String salt = UUID.randomUUID().toString();
        SimpleHash simpleHash = new SimpleHash("MD5",//算法名称
                entity.getPassword(),salt);
        entity.setPassword(simpleHash.toString());
         //保存用户信息
        sysUserDao.insertObjects(entity);
         //保存用户和角色的关系数据
        int rows = sysUserRoleDao.insertObject(entity.getId(),roleIds.split(","));
        return rows;

    }

    @Override
    public PageObject<SysUser> findPageObjects(String name, Integer pageCurrent) {
        //1.参数合法化判定
        if(pageCurrent==null || pageCurrent<1)
            throw new ServiceException("参数不合法");
        //2.获取当前页数据
          int pageSize = 2;
          int startIndex = (pageCurrent-1)*pageSize;
          List<SysUser> listUsers= sysUserDao.findPageObjects(name,startIndex,pageSize);
          int rowCount = sysUserDao.getRowCount(name);
          PageObject<SysUser> pageObject = new PageObject<SysUser>();
          pageObject.setPageCurrent(pageCurrent);
          pageObject.setPageSize(pageSize);
          pageObject.setRecords(listUsers);
          pageObject.setRowCount(rowCount);
          return pageObject;
    }

    @Override
    public int doValidById(Integer id, Integer valid, String modifiedUser) {
        // 1.验证参数的合法性
        if(id==null||id<1)throw new ServiceException("参数不合法");
        if(valid!=1&&valid!=0)throw new ServiceException("状态值无效");
        if(StringUtils.isEmpty(modifiedUser))throw new ServiceException("请先登录再修改");
        int row = sysUserDao.doValidById(id,valid,modifiedUser);
        if(row==0)throw new ServiceException("修改失败,用户可能已经不存在");
        return row;
    }
}
