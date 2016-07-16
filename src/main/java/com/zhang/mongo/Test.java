package com.zhang.mongo;

import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/25.
 */
public interface Test<T,ID extends Serializable> extends Repository<T,ID>{
}
