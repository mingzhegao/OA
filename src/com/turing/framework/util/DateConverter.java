package com.turing.framework.util;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
* <p>功能描述 ：日期格式转换 </p>
* 
* 	
	<!-- 启动Spring MVC的注解功能，完成请求和注解POJO的映射 -->
	<bean class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter" >
	 	<!-- 日期格式转换 -->
        <property name="webBindingInitializer">
         <bean class="com.yuntu.framework.util.DateConverter"/>
        </property>
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		dateFormat.setLenient(false); 
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		datetimeFormat.setLenient(false); 
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true)); 
		binder.registerCustomEditor(java.sql.Timestamp.class,new CustomTimestampEditor(datetimeFormat, true)); 
	
	</bean>
* 
*/


public class DateConverter implements WebBindingInitializer {


	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		dateFormat.setLenient(false); 
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		datetimeFormat.setLenient(false); 
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true)); 
		binder.registerCustomEditor(java.sql.Timestamp.class,new CustomTimestampEditor(datetimeFormat, true)); 
		

	}
}
