package com.itheima.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.itheima.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport{

	public String find(){
		// 调用业务层
		CustomerService customerService = new CustomerServiceImpl();
		List<Customer> list = customerService.find();
		// 页面跳转
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findSuccess";
	}
}
