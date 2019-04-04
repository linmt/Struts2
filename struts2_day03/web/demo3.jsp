<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
<h1>%号的使用</h1>
<h2>强制解析OGNL表达式</h2>
<%request.setAttribute("name","大王");%>
<s:property value="#request.name"/><br>
传统的标签可以嵌套struts2的标签：<input type="text" name="name" value="<s:property value="#request.name"/>"><br>
Struts标签不可以嵌套：<br>
Struts标签不能解析ognl表达式的情况：<s:textfield name="name" value="#request.name"/><br>
强制解析OGNL表达式：<s:textfield name="name" value="%{#request.name}"/><br>
<!--
传统的标签可以嵌套struts2的标签：大王
Struts标签不可以嵌套：
Struts标签不能解析ognl表达式的情况：  #request.name
-->

<h2>强制不解析OGNL表达式，一般没啥用</h2>
<s:property value="%{'#request.name'}"/><br>
</body>
</html>
