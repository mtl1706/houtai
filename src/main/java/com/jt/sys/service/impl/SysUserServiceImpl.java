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

import com.jt.sys.dao.SysUserDao;
import com.jt.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
