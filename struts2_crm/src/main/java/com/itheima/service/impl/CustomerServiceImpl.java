package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.CustomerDao;
import com.itheima.dao.impl.CustomerDaoImpl;
import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	public List<Customer> find() {
		// 调用DAO:
		CustomerDao customerDao = new CustomerDaoImpl();
		return customerDao.find();
	}
}
