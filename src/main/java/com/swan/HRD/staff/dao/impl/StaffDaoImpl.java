package com.swan.HRD.staff.dao.impl;

import com.swan.HRD.department.domain.Department;
import com.swan.HRD.post.domain.Post;
import com.swan.HRD.staff.dao.StaffDao;
import com.swan.HRD.staff.domain.Staff;
import com.swan.utils.secret.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

    /**
     * 登录查询验证
     *
     * @param staff
     * @return
     */
    @Override
    public List<Staff> login(Staff staff) {
        return getHibernateTemplate().findByExample(staff);
    }

    /**
     * 添加/更新员工信息
     * @param staff
     * @return
     */
    @Override
    public void saveOrUpdate(Staff staff) {
        if(StringUtils.isBlank(staff.getStaffId())){
            staff.setLoginPwd(MD5Util.md5(staff.getLoginPwd()));  //加密
            getHibernateTemplate().save(staff);
        }else{
            getHibernateTemplate().update(staff);
        }
    }

    /**
     * 查找出修改当前密码所对应的员工信息
     *
     * @param staff
     * @return
     */
    @Override
    public void changePwd(Staff staff) {
        getHibernateTemplate().update(staff);
    }

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Department> findAllDept() {
        return getHibernateTemplate().loadAll(Department.class);
    }

    /**
     * 根据部门编号查询职务
     * @return
     */
    @Override
    public List<Post> findAllPost(String depId) {
        return (List<Post>) getHibernateTemplate().find("from Post where dept.depId = ? ",depId);
    }

    /**
     * 查找全部员工
     *
     * @param
     * @return
     */
    @Override
    public List<Staff> findAll() {
        return getHibernateTemplate().loadAll(Staff.class);
    }

    /**
     * 高级查询
     * @param staff
     * @return
     */
    @Override
    public List<Staff> expertFind(Staff staff) {
        //根据postId查询出所有的员工信息
        StringBuffer sql = new StringBuffer("from Staff where 1=1");

        boolean depId = StringUtils.isBlank(staff.getPost().getDept().getDepId());
        boolean postId = StringUtils.isBlank(staff.getPost().getPostId());
        boolean staffName = StringUtils.isBlank(staff.getStaffName());

        List param = new ArrayList();
        if (!depId && postId) {
            //要根据depId查询出对应的的全部职务
            List<Post> posts = (List<Post>) getHibernateTemplate().find("from Post where dept.depId = ?", staff.getPost().getDept().getDepId());
            if (posts.size() != 0) {
                sql.append(" and post.postId = ?");
                param.add(posts.get(0).getPostId());
                if (posts.size() > 1) {
                    for (int i = 1; i < posts.size(); i++) {
                        sql.append(" or post.postId = ?");
                        param.add(posts.get(i).getPostId());
                    }
                }
            }else{
                return null;
            }
        }
        if (!postId) {
            sql.append(" and post.postId = ?");
            System.out.println(staff.getPost().getPostId());
            param.add(staff.getPost().getPostId());
        }

        if (!staffName) {
            sql.append(" and staffName like ?");
            param.add("%" + staff.getStaffName() + "%");
        }
        //集合转数组
        String params[] = new String[param.size()];
        //遍历插入
        for (int i = 0; i < param.size(); i++) {
            params[i] = param.get(i).toString();
        }
        System.out.println(sql);
        System.out.println(param);
        List<Staff> staffs = (List<Staff>) getHibernateTemplate().find(sql.toString(), params);
        System.out.println(staffs);
        return staffs;
    }

    /**
     * 更改密码中验证密码
     * @param staff
     * @return
     */
    @Override
    public List<Staff> findStaff(Staff staff) {
        return (List<Staff>) getHibernateTemplate().find("from Staff where loginName = ? and  loginPwd = ?",staff.getLoginName(),staff.getLoginPwd());
    }


    /**
     * 根据条件查询员工信息
     * @param staff
     * @return
     */
    @Override
    public List<Staff> find(Staff staff) {
        return (List<Staff>) getHibernateTemplate().find("from Staff where staffId = ?",staff.getStaffId());
    }


}
