package com.zhang.controller;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.zhang.dao.UserDao;
import com.zhang.vo.User;

/**  
 * @author ZJK
 * @date 2016年3月7日 下午2:22:02
 */
@Controller
public class TestContrller {

    @Resource
    private UserDao userDao;
    
    @RequestMapping(value="test")
    public Callable<String> processUpload(final String sss) {
        return new Callable<String>() {
            public String call() throws Exception {
                System.out.println(sss);
                return "index";
            }
        };
    }
    
    @RequestMapping("save")
    public void save() {
        com.zhang.entity.User user1 = new com.zhang.entity.User();
        user1.setUserName("Zhang");
        user1.setPassword("pwd");
        userDao.save(user1);
    }
    
    @RequestMapping("find")
    public void find() {
        userDao.find();
    }
    
    
    @RequestMapping(value="test1")
    public RedirectView test() {
        System.out.println(UserDao.class.getClassLoader());
        System.out.println(userDao.getClass().getClassLoader());
        System.out.println(UserDao.map == userDao.map);
        System.out.println(UserDao.map.equals(userDao.map));
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
    
    @RequestMapping("tt")
    public void tt() {
        String name = ManagementFactory.getRuntimeMXBean().getName();    
        System.out.println(name);    
        String pid = name.split("@")[0];    
        System.out.println("Pid is:" + pid); 
    }
    
    
}
