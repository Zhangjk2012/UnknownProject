package com.zhang.test;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhang.dao.UserDao;
import com.zhang.entity.User;

/**  
 * @author ZJK
 * @date 2016年3月8日 上午11:59:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test {
    
    @Resource
    private UserDao userDao;
    
    @org.junit.Test
    public void saveTest() {
        
        User user1 = new User();
        user1.setUserName("Zhang");
        user1.setPassword("pwd");
        
        userDao.find();
        userDao.find();
//        userDao.save(user2);
//        userDao.save(user3);
    }
    
    
}
