package com.jt.sys.entity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jt.common.util.DateConvertUtil;

import java.io.Serializable;
import java.util.Date;
/**角色实体对象*/
public class SysRole implements Serializable{
	private static final long serialVersionUID = 3098457856539501697L;
    private Integer id;
    private String name;
    private String note;
    //客户端向服务端传的日期格式假如是yyyy/MM/dd这种格式，可以进行默认处理。
    //@JsonFormat(pattern="yyyy/MM/dd")
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@JsonSerialize(using=DateConvertUtil.class)
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@JsonSerialize(using=DateConvertUtil.class)
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	@Override
	public String toString() {
		return "SysRole [id=" + id + ", name=" + name + ", note=" + note + ", createdTime=" + createdTime
				+ ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser
				+ "]";
	}
    

}
