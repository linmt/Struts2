package com.itheima.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	// 查询客户的方法
	public List<Customer> find() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer").list();
		
		tx.commit();
		return list;
	}

	@Override
	// 保存客户的方法
	public void save(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		session.save(customer);
		
		tx.commit();
	}

}
