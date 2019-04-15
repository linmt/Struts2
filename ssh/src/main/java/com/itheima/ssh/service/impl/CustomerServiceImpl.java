package com.itheima.ssh.service.impl;

import com.itheima.ssh.dao.CustomerDao;
import com.itheima.ssh.domain.Customer;
import com.itheima.ssh.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
/**
 * 客户管理的Service的实现类
 * @author jt
 * <bean id="customerService" class="com.itheima.ssh.service.impl.CustomerServiceImpl">
 * </bean>
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	// 注入DAO:
	@Resource(name="customerDao")
	private CustomerDao customerDao;
	
	@Override
	public void save(Customer customer) {
		System.out.println("Service中的save方法执行了...");
		customerDao.save(customer);
	}

}
