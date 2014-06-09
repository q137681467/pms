package com.jinbo.pms.test;


import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("spring-base.xml");

	// 测试SessionFactory
	@Test
	public void testSessionFactory() throws Exception {
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		System.out.println(sessionFactory);
	}

	// 测试事务
	@Test
	public void testTx() throws Exception {
		TestService testService = (TestService) ac.getBean("testService");
		System.out.println(testService);
		// testService.saveTwoUsers();
		testService.saveTwoUsers();
	}

}
