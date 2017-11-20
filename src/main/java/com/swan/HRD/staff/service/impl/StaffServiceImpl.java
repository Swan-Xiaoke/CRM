package com.swan.HRD.staff.service.impl;

import com.swan.HRD.department.domain.Department;
import com.swan.HRD.post.domain.Post;
import com.swan.HRD.staff.dao.StaffDao;
import com.swan.HRD.staff.dao.impl.StaffDaoImpl;
import com.swan.HRD.staff.domain.Staff;
import com.swan.HRD.staff.service.StaffService;
import com.swan.utils.secret.MD5Util;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    /**
     * 登录
     *
     * @param st Staff
     * @return
     */
    @Override
    public List<Staff> login(Staff st) {
        return staffDao.login(st);
    }

    /**
     * 查找全部员工
     *
     * @param
     * @return
     */
    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }


    /**
     * 更改密码
     *
     * @param staff
     * @return
     */
    @Override
    public void changePwd(Staff staff) {
        staffDao.changePwd(staff);
    }

    /**
     * 查询所有部门信息
     *
     * @return
     */
    @Override
    public List<Department> findAllDept() {
        return staffDao.findAllDept();
    }

    /**
     * 根据信息查询职位
     *
     * @param post
     * @return
     */
    @Override
    public List<Post> findAllPost(String post) {
        return staffDao.findAllPost(post);
    }

    /**
     * 高级查询
     *
     * @param staff
     * @return
     */
    @Override
    public List<Staff> expertFind(Staff staff) {
        return staffDao.expertFind(staff);
    }

    /**
     * 更改密码中的密码校验
     *
     * @param staff
     * @return
     */
    @Override
    public List<Staff> findStaff(Staff staff) {
        staff.setLoginPwd(MD5Util.md5(staff.getLoginPwd()));
        return staffDao.findStaff(staff);
    }

    /**
     * 根据条件查询员工信息
     *
     * @param staff
     * @return
     */
    @Override
    public List<Staff> find(Staff staff) {
        return staffDao.find(staff);
    }

    /**
     * 更新员工信息
     *
     * @param staff
     */
    @Override
    public void saveOrUpdate(Staff staff) {
        staffDao.saveOrUpdate(staff);
    }

    /**
     * get & set 方法
     *
     * @param staffDao
     */
    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public StaffDao getStaffDao() {
        return staffDao;
    }
}
