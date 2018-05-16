package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tedu on 2018/5/8.
 */
public interface SysUserService {
    PageObject<SysUser> findPageObjects(String name, Integer pageCurrent);
}
