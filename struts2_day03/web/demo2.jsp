<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
<h1>#号使用</h1>
<h2>获取context的数据</h2>
<%request.setAttribute("name","饺子");%>
<s:property value="#request.name"/>

<h2>用于构建一个List集合</h2>
<s:iterator value="{'aaa','bbb''}" var="entry">
    <s:property value="entry"/>---<s:property value="#entry"/><br/>
</s:iterator>

<h2>用于构建一个Map集合</h2>
<s:iterator value="#{'aaa':'111','bbb':'222'}" var="entry">
    <s:property value="key"/>---<s:property value="value"/><br/>
    <s:property value="#entry.key"/>---<s:property value="#entry.value"/><br/>
</s:iterator>

<h2>传统单选框</h2>
性别：<input type="radio" name="sex1" value="男">男
<input type="radio" name="sex1" value="女">女

<h2>List单选框——既可以点文字，也可以点选择框</h2>
<s:radio list="{'男','女'}" name="sex2" label="性别"/>

<h2>Map单选框——既可以点文字，也可以点选择框</h2>
<s:radio list="#{'1':'男','2':'女'}" name="sex3" label="性别"/>

<!--
#号使用
获取context的数据
饺子
用于构建一个List集合
用于构建一个Map集合
aaa---111
aaa---111
bbb---222
bbb---222
传统单选框
性别：男 女
List单选框——既可以点文字，也可以点选择框
性别:  男 女
Map单选框——既可以点文字，也可以点选择框
性别:  男 女
-->
</body>
</html>
