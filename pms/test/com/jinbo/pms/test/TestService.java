package com.jinbo.pms.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jinbo.pms.rbac.model.User;


@Service("TestService")
public class TestService {

	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public void saveTwoUsers() {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(session);
		User user= new User();
		user.setUsername("zhengdq");
		user.setPassword("123456");
		session.save(user);
//		int a = 1 / 0; // 这行会抛异常
		User user3= new User();
		user3.setUsername("zhengdq2");
		user3.setPassword("123456");
		session.save(user3);
	}

	@Transactional
	public void save25Users() {
		Session session = sessionFactory.getCurrentSession();

		for (int i = 1; i <= 25; i++) {
//			User user = new User();
//			user.setName("test_" + i);
//			session.save(user);
		}
	}
}
