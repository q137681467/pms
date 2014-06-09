package com.jinbo.pms.test;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestLog4j {

	@Test
	public void test() throws Exception {
		Log log = LogFactory.getLog(getClass());
		log.debug("这是debug日志"); // 调试信息，级别最低
		log.info("这是info日志"); // 一般信息
		log.warn("这是warn日志"); // 警告信息
		log.error("这是error日志"); // 错误信息
		log.fatal("这是fatal日志"); // 严重错误信息，级别最高
	}
}
