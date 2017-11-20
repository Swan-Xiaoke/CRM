package com.swan.HRD.department.dao.impl;

import com.swan.HRD.department.dao.DepartmentDao;
import com.swan.HRD.department.domain.Department;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.LockMode;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class DepartmentImpl extends HibernateDaoSupport implements DepartmentDao {

    /**
     * 查询所有部门
     * @return 返回部门信息集合
     */
    @Override
    public List<Department> findAll() {
        return getHibernateTemplate().loadAll(Department.class);
    }

    /**
     * 添加/更新部门信息
     * 获取部门编号,通过编号来更新部门信息
     * @param dept 部门ID
     */
    @Override
    public void saveOrUpdate(Department dept){
        //判断depId是否存在
        System.out.println("================================" + dept.getDepId());
        System.out.println(dept.getDepName());
        //如果不存在执行保存,如果不存在执行更新
        if(StringUtils.isBlank(dept.getDepId())) {
            getHibernateTemplate().save(dept);
        }else {
            getHibernateTemplate().update(dept);
        }
    }

    /**
     * 通过部门ID查信息
     * @param dept 部门信息
     * @return
     */
    @Override
    public List<Department> find(Department dept) {
        return getHibernateTemplate().findByExample(dept);
    }

}
