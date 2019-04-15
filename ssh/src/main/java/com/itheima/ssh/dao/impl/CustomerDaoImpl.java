package com.itheima.ssh.dao.impl;

import com.itheima.ssh.dao.CustomerDao;
import com.itheima.ssh.domain.Customer;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
/**
 * 客户管理的DAO的实现类
 * @author jt
 * <bean id = "customerDao" class="com.itheima.ssh.dao.impl.CustomerDaoImpl">
 * </bean>
 */
@Repository("customerDao")
/*
这里不能继承HibernateDaoSupport，里面有变量HibernateTemplate，这是Hibernate的模板，
我们如果继承HibernateDaoSupport，要把applicationContext.xml中的sessionFactory注入HibernateTemplate
 */
public class CustomerDaoImpl implements CustomerDao {
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(Customer customer) {
		System.out.println("DAO中的save方法执行了...");
		this.hibernateTemplate.save(customer);
	}

}
