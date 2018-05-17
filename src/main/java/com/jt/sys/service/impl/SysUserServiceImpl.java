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
import com.jt.sys.entity.SysUser;
import com.jt.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
