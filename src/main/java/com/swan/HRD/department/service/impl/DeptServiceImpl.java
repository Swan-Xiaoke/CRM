package com.swan.HRD.department.service.impl;

import com.swan.HRD.department.dao.DepartmentDao;
import com.swan.HRD.department.dao.impl.DepartmentImpl;
import com.swan.HRD.department.domain.Department;
import com.swan.HRD.department.service.DeptService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.components.Bean;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class DeptServiceImpl implements DeptService {
    private DepartmentDao deptDao;

    /**
     * 查询所有部门
     * @return 返回部门的集合
     */
    @Override
    public List<Department> findAll() {
        return deptDao.findAll();
    }

    /**
     * 添加部门
     * @param dept 传入部门变编号
     */
    @Override
    public void saveOrUpdate(Department dept) {
        if (StringUtils.isBlank(dept.getDepName())) {
            dept.setDepId(null);
        }
        deptDao.saveOrUpdate(dept);
    }

    /**
     * 通过ID查找部门信息
     * @param dept 部门ID
     * @return
     */
    @Override
    public List<Department> find(Department dept) {
        return deptDao.find(dept);
    }

    /**
     * get & set 方法
     * @return
     */
    public void setDeptDao(DepartmentDao deptDao) {
        this.deptDao = deptDao;
    }

}
