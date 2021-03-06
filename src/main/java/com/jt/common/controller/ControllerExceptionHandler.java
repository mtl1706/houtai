package com.jt.common.controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jt.common.exception.ServiceException;
import com.jt.common.vo.JsonResult;


/**全局异常处理类*/
@ControllerAdvice
public class ControllerExceptionHandler {
	 @ExceptionHandler(ServiceException.class)
	 @ResponseBody
	 public JsonResult handleServiceException(
		ServiceException e){
		e.printStackTrace();
		return new JsonResult(e);
		//return JsonResult.error(e);
	 }
}
