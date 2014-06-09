package com.jinbo.pms.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 * @author Administrator
 *
 */
@Controller("indexController")
public class IndexController {
    
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request,Model model){
    	System.out.println("controller测试");
    	 model.addAttribute("msgs","username.illegal");
        return "index";
    }

}
