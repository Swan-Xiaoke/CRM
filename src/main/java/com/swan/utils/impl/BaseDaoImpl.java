package com.swan.utils.impl;

import com.opensymphony.xwork2.interceptor.annotations.After;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.swan.HRD.staff.domain.Staff;
import com.swan.utils.BaseDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class BaseDaoImpl implements BaseDao {

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public List find(Object o) {
        return null;
    }

    @Override
    public void saveOrUpdate(Object o) {

    }

}
