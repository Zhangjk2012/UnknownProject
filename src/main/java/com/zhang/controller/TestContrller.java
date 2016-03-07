package com.zhang.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.zhang.vo.User;

/**  
 * @author ZJK
 * @date 2016年3月7日 下午2:22:02
 */
@Controller
public class TestContrller {

    @RequestMapping(value="test")
    public Callable<String> processUpload(final String sss) {
        return new Callable<String>() {
            public String call() throws Exception {
                System.out.println(sss);
                return "index";
            }
        };
    }
    
    @RequestMapping(value="test1")
    public RedirectView test() {
        return new RedirectView("index.jsp");
    }
    
    @RequestMapping("ftl")
    public String testFtl() {
        return "test1";
    }
    
    @RequestMapping("/index")  
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {  
  
        User user = new User();  
        user.setUsername("zhangsan");  
        user.setPassword("1234");  
        List<User> users = new ArrayList<User>();  
        users.add(user);  
        return new ModelAndView("test1", "users", users);  
    } 
}
