package com.swan.HRD.staff.dao;

import com.swan.HRD.department.domain.Department;
import com.swan.HRD.post.domain.Post;
import com.swan.HRD.staff.domain.Staff;
import com.swan.utils.BaseDao;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffDao extends BaseDao<Staff>{


    /**
     * 根据条件查找员工
     * @param staff
     * @return
     */
    List<Staff> find(Staff staff);

    /**
     * 登录
     * @param user
     * @return
     */
    List<Staff> login(Staff user);

    /**
     * 更改密码
     * @param staff
     * @return
     */
    void changePwd(Staff staff);

    /**
     * 查询所有部门
     * @return
     */
    List<Department> findAllDept();

    /**
     * 查询所有职位
     * @return
     */
    List<Post> findAllPost(String post);

    /**
     * 高级查询
     * @param staff
     * @return
     */
    public List<Staff> expertFind(Staff staff);

    /**
     * 更改密码中验证密码
     * @param staff
     * @return
     */
    public List<Staff> findStaff(Staff staff);
}
