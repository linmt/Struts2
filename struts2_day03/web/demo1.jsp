<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 引入Struts2标签库 -->    
<%@ taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  
	1. 先引入Struts2框架提供的标签库，s标签
	2.在struts.xml中开启访问静态方法的选项
	3. http://localhost:8080/demo1/demo1.jsp
-->

<!-- 调用对象的方法 -->
<s:property value="'username'.length()"/>
<!-- 调用对象的静态方法 默认是不能访问静态方法的，要在struts.xml中开启 -->
<s:property value="@java.lang.Math@random()"/>
</body>
</html>







