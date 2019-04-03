<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head></head>
<body>
<h1>查看值栈的内部结构</h1>
<!-- 在JSP页面上，查看值栈的内部结构 -->
<s:debug></s:debug>
获取user.name：<s:property value="user.name"/>
获取name：<s:property value="name"/>
获取msg：<s:property value="msg"/>
</body>
</html>
