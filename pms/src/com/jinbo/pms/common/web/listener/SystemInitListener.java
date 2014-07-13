package com.jinbo.pms.common.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 系统初始化监听器，在系统启动时运行，进行一些初始化工作
 * @author merlin
 *
 */
public class SystemInitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Desotroyed Listener System Init");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// ServletContext servletContext = sce.getServletContext();
		// BaseFieldsService baseFieldsService =
		// SpringContextHolder.getBean("baseFieldsServiceImpl");
		// Criteria criteria = new Criteria();
		// criteria.setOrderByClause(" field desc ,sort asc ");
		// criteria.put("enabled", "1");
		// servletContext.setAttribute("fields",
		// baseFieldsService.selectAllByExample(criteria));
		//第一部分：对数据字典进行缓存
		System.out.println("Start Listener System Init");
	}

}
