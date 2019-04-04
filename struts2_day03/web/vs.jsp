<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>从值栈中获取值</h3>
<!-- vs.push("美美"); -->
<!-- 获取到栈顶的值：美美 -->
获取到栈顶的值：<s:property value="[0].top"/></br>

<!--
	// 栈顶是map集合，通过key获取值
	vs.push("美美");
    vs.set("msg", "小凤");
-->
<!--
获取到栈顶的值：{msg=小凤, com.opensymphony.xwork2.util.OgnlValueStack.MAP_IDENTIFIER_KEY=}
[0].top.msg：小凤
-->
[0].top.msg：<s:property value="[0].top.msg"/></br>

<!--  
vs.push("美美");
vs.set("msg", "小凤");

User user = new User("小苍",111);
vs.push(user);
-->
<!--
获取到栈顶的值：User [name=小苍, age=111]
[0].top.msg：
[0].top.name：小苍
[0].top.age：111
name：小苍
-->
[0].top.name：<s:property value="[0].top.name"/></br>
[0].top.age：<s:property value="[0].top.age"/></br>
<!-- [0].top 关键字是可以省略的  findValue() -->
name：<s:property value="name"/></br>

<!--
vs.push("美美");
vs.set("msg", "小凤");

User user = new User("小苍",111);
vs.push(user);
vs.set("user", user);
-->
<!--
获取到栈顶的值：{user=User [name=小苍, age=111], com.opensymphony.xwork2.util.OgnlValueStack.MAP_IDENTIFIER_KEY=}
[0].top.msg：
[0].top.name：
[0].top.age：
name：小苍
[0].top.user.name：小苍
[0].top.user.age：111
user.name：小苍
-->
[0].top.user.name：<s:property value="[0].top.user.name"/></br>
[0].top.user.age：<s:property value="[0].top.user.age"/></br>
<!-- [0].top 关键字是可以省略的 -->
user.name：<s:property value="user.name"/></br>


<!--  
		栈顶是list集合
        vs.push("美美");
        vs.set("msg", "小凤");

        User user = new User("小苍",111);
        vs.push(user);
        vs.set("user", user);

        List<User> ulist = new ArrayList<User>();
        ulist.add(new User("熊大",123));
        ulist.add(new User("熊二",456));
        ulist.add(new User("熊三",789));
         //把ulist集合压栈
         vs.push(ulist);
-->
<!--
获取到栈顶的值：[User [name=熊大, age=123], User [name=熊二, age=456], User [name=熊三, age=789]]
[0].top.msg：
[0].top.name：
[0].top.age：
name：小苍
[0].top.user.name：
[0].top.user.age：
user.name：小苍
栈顶是list集合
[0].top[0].name：熊大
[0].top[1].name：熊二
-->
栈顶是list集合</br>
[0].top[0].name：<s:property value="[0].top[0].name"/></br>
[0].top[1].name：<s:property value="[0].top[1].name"/></br>

<!--
        vs.push("美美");
        vs.set("msg", "小凤");

        User user = new User("小苍",111);
        vs.push(user);
        vs.set("user", user);

        List<User> ulist = new ArrayList<User>();
        ulist.add(new User("熊大",123));
        ulist.add(new User("熊二",456));
        ulist.add(new User("熊三",789));
         //把ulist集合压栈
         vs.push(ulist);

        // set方法进行压栈
        vs.set("ulist", ulist);
-->
<!--
获取到栈顶的值：{ulist=[User [name=熊大, age=123], User [name=熊二, age=456], User [name=熊三, age=789]], com.opensymphony.xwork2.util.OgnlValueStack.MAP_IDENTIFIER_KEY=}
[0].top.msg：
[0].top.name：
[0].top.age：
name：小苍
[0].top.user.name：
[0].top.user.age：
user.name：小苍
栈顶是list集合
[0].top[0].name：
[0].top[1].name：
栈顶是set方法放入的集合
ulist[0].username：熊大
-->
栈顶是set方法放入的集合</br>
ulist[0].username：<s:property value="ulist[0].name"/></br>

<!--
* value	要迭代的集合，需要从值栈中获取
* var	迭代过程中，遍历的对象
	* var编写上，把迭代产生的对象默认压入到context栈中，从context栈取值，加#号
	* var不编写，默认把迭代产生的对象压入到root栈中
-->
<!--
获取到栈顶的值：{ulist=[User [name=熊大, age=123], User [name=熊二, age=456], User [name=熊三, age=789]], com.opensymphony.xwork2.util.OgnlValueStack.MAP_IDENTIFIER_KEY=}
[0].top.msg：
[0].top.name：
[0].top.age：
name：小苍
[0].top.user.name：
[0].top.user.age：
user.name：小苍
栈顶是list集合
[0].top[0].name：
[0].top[1].name：
栈顶是set方法放入的集合
ulist[0].username：熊大
迭代----编写var的属性
熊大 123 熊二 456 熊三 789
迭代----没有编写var关键字
熊大 123 熊二 456 熊三 789
-->
迭代----编写var的属性</br>
<s:iterator value="ulist" var="u">
	<s:property value="#u.name"/>
	<s:property value="#u.age"/>
</s:iterator>
</br>
迭代----没有编写var关键字</br>
<s:iterator value="ulist">
	<s:property value="name"/>
	<s:property value="age"/>
</s:iterator>
</br>

<!--
        vs.push("美美");
        vs.set("msg", "小凤");

        User user = new User("小苍",111);
        vs.push(user);
        vs.set("user", user);

        List<User> ulist = new ArrayList<User>();
        ulist.add(new User("熊大",123));
        ulist.add(new User("熊二",456));
        ulist.add(new User("熊三",789));
         //把ulist集合压栈
         vs.push(ulist);

        // set方法进行压栈
        vs.set("ulist", ulist);


		// 从context栈中获取值，底层已经封装到request session对象，操作就是map集合
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("msg", "花花");
-->
<!--
获取到栈顶的值：{ulist=[User [name=熊大, age=123], User [name=熊二, age=456], User [name=熊三, age=789]], com.opensymphony.xwork2.util.OgnlValueStack.MAP_IDENTIFIER_KEY=}
[0].top.msg：
[0].top.name：
[0].top.age：
name：小苍
[0].top.user.name：
[0].top.user.age：
user.name：小苍
栈顶是list集合
[0].top[0].name：
[0].top[1].name：
栈顶是set方法放入的集合
ulist[0].username：熊大
迭代----编写var的属性
熊大 123 熊二 456 熊三 789
迭代----没有编写var关键字
熊大 123 熊二 456 熊三 789
从context栈中获取值，加#号
#request.msg：花花
#session.msg：
#parameters.id：
#attr.msg：花花
-->
从context栈中获取值，加#号</br>
#request.msg：<s:property value="#request.msg"/></br>
#session.msg：<s:property value="#session.msg"/></br>
#parameters.id：<s:property value="#parameters.id"/></br>
#attr.msg：<s:property value="#attr.msg"/></br>

<!--
        vs.push("美美");
        vs.set("msg", "小凤");

        User user = new User("小苍",111);
        vs.push(user);
        vs.set("user", user);

        List<User> ulist = new ArrayList<User>();
        ulist.add(new User("熊大",123));
        ulist.add(new User("熊二",456));
        ulist.add(new User("熊三",789));
         //把ulist集合压栈
         vs.push(ulist);

        // set方法进行压栈
        vs.set("ulist", ulist);


		// 从context栈中获取值，底层已经封装到request session对象，操作就是map集合
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("msg", "花花");
		request.getSession().setAttribute("msg", "小草");
-->
<!--
http://localhost:8080/showvs/save?id=123
-->
<!--
获取到栈顶的值：{ulist=[User [name=熊大, age=123], User [name=熊二, age=456], User [name=熊三, age=789]], com.opensymphony.xwork2.util.OgnlValueStack.MAP_IDENTIFIER_KEY=}
[0].top.msg：
[0].top.name：
[0].top.age：
name：小苍
[0].top.user.name：
[0].top.user.age：
user.name：小苍
栈顶是list集合
[0].top[0].name：
[0].top[1].name：
栈顶是set方法放入的集合
ulist[0].username：熊大
迭代----编写var的属性
熊大 123 熊二 456 熊三 789
迭代----没有编写var关键字
熊大 123 熊二 456 熊三 789
从context栈中获取值，加#号
#request.msg：花花
#session.msg：小草
#parameters.id：123
#attr.msg：花花
从context栈中获取值，加#号
#request.msg：花花
#session.msg：小草
#parameters.id：123
#application.msg：权志龙
如果request中没有数据，会从session中找，session中没有，从application中找
#attr.msg：花花
-->
从context栈中获取值，加#号</br>
#request.msg：<s:property value="#request.msg"/></br>
第一次访问，session中没有数据？</br>
#session.msg：<s:property value="#session.msg"/></br>
#parameters.id：<s:property value="#parameters.id"/></br>
#application.msg：<s:property value="#application.msg"/></br>
如果request中没有数据，会从session中找，session中没有，从application中找</br>
#attr.msg：<s:property value="#attr.msg"/></br>


<!--
熊大 -- 123 熊二 -- 456 熊三 -- 789
-->
<c:forEach items="${ ulist }" var="user">
	${ user.name } -- ${ user.age }
</c:forEach>

<!-- 在JSP页面上，查看值栈的内部结构 -->
<s:debug></s:debug>
</body>
</html>