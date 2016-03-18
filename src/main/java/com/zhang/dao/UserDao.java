package com.zhang.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.CacheMode;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zhang.entity.User;

/**  
 * @author ZJK
 * @date 2016年3月8日 下午12:01:15
 */
@Repository
public class UserDao {
    
    public final static Map<String, String> map = new HashMap<String, String>();
    
    static {
        System.out.println("ssssssssssssssss");
    }
    
    @Resource
    private SessionFactory sessionFactory;
    
    @Transactional
    public Object save(Object u) {
        sessionFactory.getCurrentSession().save(u);
        return u;
    }
    
    @Transactional
    public void find() {
        sessionFactory.getCurrentSession().createQuery("from User").setCacheable(true).list();
    }
    
}
