package com.zhang.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.zhang.utils.RedisExecutor;
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
        
        com.zhang.entity.Test t = new com.zhang.entity.Test();
        
        List<String> s = new ArrayList<String>();
        s.add("1");
        s.add("3");
        
        t.setAddress(s);
        
        userDao.save(t);
//        userDao.save(user3);
    }

    @Resource(name="redisExecutor")
    RedisExecutor executor;

    @org.junit.Test
    public void test() {
        executor.set("test","test");
    }
    
}
