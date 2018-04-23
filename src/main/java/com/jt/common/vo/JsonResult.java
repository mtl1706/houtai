package com.jt.common.vo;

import java.io.Serializable;

/**借助此对象封装控制层结果*/
public class JsonResult implements Serializable{
	private static final long serialVersionUID = -856924038217431339L;
	/**表示状态码 1表示Ok,0表示失败*/
	private int state=1;
	/**具体消息*/
	private String message="ok";
	/**具体数据(一般用于封装查询的数据)*/
	private Object data;
	public JsonResult() {}
	public JsonResult(Object data){
		this.data=data;
	}
	public JsonResult(String message){
		this.message=message;
	}
	public JsonResult(Object data,String message){
		this.data=data;
		this.message=message;
	}
	public JsonResult(Throwable tx){
		this.state=0;
		this.message=tx.getMessage();
	}
	public static JsonResult ok(String msg){
		return new JsonResult(msg);
	}
	public static JsonResult error(Throwable tx){
		return new JsonResult(tx);
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public JsonResult setData(Object data) {
		this.data = data;
		return this;
	}
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
	
	
}
