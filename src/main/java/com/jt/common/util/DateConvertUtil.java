package com.jt.common.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**自定义json序列化对象
 * 1)此类的作用?自定义对象转换
 * 2)此类如何使用？
 * 在对应实体bean对象的get方法上使用@JsonSerialize注解进行引用
 * */
public class DateConvertUtil extends JsonSerializer<Date>{
	public DateConvertUtil() {
		System.out.println("DateConvertUtil()");
	}
	/**
	 * @param value 表示要转换的对象
	 * @param gen 表示json串生成器
	 * @param serializers json 串序列化提供者 (暂且不用关系)
	 */
	@Override
	public void serialize(Date value,
			JsonGenerator gen,
			SerializerProvider serializers)
			throws IOException, 
			JsonProcessingException {
		//1.创建日期转换对象(如何保障如下对象每个线程有一份：课后了解ThreadLocal)
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		//2.将日期对象转换为指定格式的字符串
		String dateStr=sdf.format(value);
		//3.将此字符串写入到json串中
		gen.writeString(dateStr);
	}


}
