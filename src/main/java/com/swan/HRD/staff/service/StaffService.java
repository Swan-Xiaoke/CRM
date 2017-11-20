package com.swan.HRD.staff.service;

import com.swan.HRD.department.domain.Department;
import com.swan.HRD.post.domain.Post;
import com.swan.HRD.staff.domain.Staff;
import com.swan.utils.BaseDao;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface StaffService extends BaseDao<Staff> {
    /**
     * 登录方法
     * @param staff 员工对象
     * @return
     */
    List<Staff> login(Staff staff);

    /**
     * 更改密码
     * @param staff 员工对象
     * @return
     */
    void changePwd(Staff staff);

    /**
     * 查询所有部门
     * @return 返回部门集合
     */
    List<Department> findAllDept();

    /**
     * 根据部门编号查询职务
     * @param post
     * @return
     */
    List<Post> findAllPost(String post);

    /**
     * 高级查询
     * @param staff
     * @return
     */
    List<Staff> expertFind(Staff staff);

    /**
     * 更改密码中的密码校验
     * @param staff
     * @return
     */
    List<Staff> findStaff(Staff staff);
}
