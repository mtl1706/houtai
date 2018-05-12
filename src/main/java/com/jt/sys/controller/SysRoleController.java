package com.jt.sys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysRole;
import com.jt.sys.service.SysRoleService;

@RequestMapping("/role/")
@Controller
public class SysRoleController {
	 @Autowired
     private SysRoleService sysRoleService;
	 @RequestMapping("listUI")
	 public String listUI(){
		 return "sys/role_list";
		 //WEB-INF/pages/sys/role_list.html
	 }
	 @RequestMapping("editUI")
	 public String editUI(){
		return "sys/role_edit";
	 }

	 @RequestMapping("doFindPageObjects")
	 @ResponseBody
	 public JsonResult doFindPageObjects(Integer pageCurrent,String name){
		PageObject<SysRole> pageObject= sysRoleService.findPageObjects(pageCurrent,name);
		/*return JsonResult.ok("query ok")
				.setData(pageObject);*/
		 System.out.println("name="+name);
		return new JsonResult(pageObject,"query ok");
	 }
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id){
		sysRoleService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	//添加角色
    @RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysRole entity){
		sysRoleService.saveObject(entity);
		return new JsonResult("save ok");
	}
	//修改角色
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysRole entity){
		sysRoleService.updateObject(entity);
		return new JsonResult("update ok");
	}


}
