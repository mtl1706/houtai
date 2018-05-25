/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: SysUserController
 * Author:   tedu
 * Date:     2018/5/8 22:29
 * Description:
 * History:
 * <author>          <time&date>          <version>          <desc>
 * 作者姓名           修改时间             版本号             描述
 */
package com.jt.sys.controller;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.service.SysRoleService;
import com.jt.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author tedu
 * @create 2018/5/8
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user/")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("editUI")
    public String editUI(){
        return "sys/user_edit";
    }
    @RequestMapping("listUI")
    public String loadUserListPage(){
        return "sys/user_list";
    }

    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String name ,Integer pageCurrent){
        PageObject pageObject= sysUserService.findPageObjects(name,pageCurrent);
        JsonResult json = new JsonResult(pageObject);
        System.out.println(json);
        return json;
    }
    @RequestMapping("doValidById")
    @ResponseBody
    public JsonResult doValidById(Integer id,Integer valid){
        sysUserService.doValidById(id,valid,"admin");
        return new JsonResult(valid==1?"启用OK":"禁用OK");
    }
}