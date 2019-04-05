package com.itheima.web.action;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户的Action的类
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	// 接收数据:
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	
	/**
	 * 用户登录的方法:
	 */
	public String login(){
		System.out.println(user);
		// 调用业务层:
		UserService userService = new UserServiceImpl();
		User existUser = userService.login(user);
		// 根据结果页面跳转：
		if(existUser == null){
			// 登录失败
			// ActionSupport自带的三种向页面传递信息的方法：ActionError、FieldError、ActionMessage
			this.addActionError("用户名或密码错误！");
			return LOGIN;
		}else{
			// 登录成功
			// ActionContext.getContext().getSession().put("existUser", "existUser");
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return SUCCESS;
		}
	}
}
