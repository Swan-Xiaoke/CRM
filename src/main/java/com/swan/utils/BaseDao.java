package com.swan.utils;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface BaseDao<T>{
    //查询所有
    List<T> findAll();
    //高级查询(根据传入参数)
    List<T> find(T t);
    //保存/更新数据
    void saveOrUpdate(T t);

}
