package com.jinbo.pms.test;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {

	@Resource(name = "testService")
	private TestService testService;

	@RequestMapping(value = "/test")
	public ModelAndView test() {
		testService.saveTwoUsers();
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "HelloMVC");
		return mv;
	}

	@RequestMapping(value = "/add")
	public String add(HttpServletRequest arg0, HttpServletResponse arg1) {
		String str = "add";
		arg0.setAttribute("str", str);
		return "Multi";
	}
}
