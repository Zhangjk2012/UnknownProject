package com.zhang.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**  
 * @author ZJK
 * @date 2016年3月11日 上午9:35:16
 */
@Entity
public class Test {
    
    @Id
    @GeneratedValue
    private int id;
    
    @ElementCollection
    @CollectionTable(name="address", joinColumns=@JoinColumn(name="user_id"))
    @Column(name = "address")
    private List<String> address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
    
}
