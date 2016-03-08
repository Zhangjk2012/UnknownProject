package com.zhang.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**  
 * @author ZJK
 * @date 2016年3月8日 上午11:25:16
 */
@Entity
@Table(name="user")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class User {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    
    @NotNull(message="{message.username.empty}")
    @Size(min = 2, max = 140,message="{message.username.length}")
    private String userName;//发布内容
    
    @NotNull(message="{message.password.empty}")
    @Size(min = 2, max = 140,message="{message.password.length}")
    private String password;//七牛图片信息

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
