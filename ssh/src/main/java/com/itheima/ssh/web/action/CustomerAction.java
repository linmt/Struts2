package com.itheima.ssh.web.action;

import com.itheima.ssh.domain.Customer;
import com.itheima.ssh.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
/**
 * @author jt
 * * 将Action交给Spring管理:
 * <bean id="customerAction" class="com.itheima.ssh.web.action.CustomerAction" scope="prototype">
 * </bean>
 * * 配置Action的访问
 * <package name="demo" extends="struts-default" namespace="/">
 * 	<action name="customer_save" class="customerAction" method="save">
 * 	<action name="customer_update" class="customerAction" method="update">
 * 	</action>
 * </package>
 */
@Controller("customerAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	// 模型驱动使用的对象
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	// 注入Service:
	@Resource(name="customerService")
	private CustomerService customerService;

	// 保存客户的方法：save
	@Action(value="customer_save",results={@Result(name="success",location="/login.jsp")})
	public String save(){
		System.out.println("Action中的save方法执行了...");
		customerService.save(customer);
		System.out.println("插入了");
		return SUCCESS;
	}
}
