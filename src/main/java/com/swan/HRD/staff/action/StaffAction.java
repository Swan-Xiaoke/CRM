package com.swan.HRD.staff.action;

import com.swan.HRD.department.domain.Department;
import com.swan.HRD.post.domain.Post;
import com.swan.HRD.staff.domain.Staff;
import com.swan.HRD.staff.service.StaffService;
import com.swan.utils.BaseAction;
import com.swan.utils.secret.MD5Util;
import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * Created by dllo on 17/11/9.
 * 验证方式不规范
 */

public class StaffAction extends BaseAction<Staff, StaffService> {

    private List<Staff> staffs;
    private List<Department> departments;
    private List<Post> posts;
    private String depId;

    /**
     * 登录方法
     *
     * @return
     */
    public String login() {
        getRequest().getSession().setAttribute("loginName", getModel().getLoginName());
        getRequest().getSession().setAttribute("staffName", getModel().getStaffName());
        return SUCCESS;
    }

    /**
     * 查找所有员工信息
     *
     * @return
     */
    public String allStaff() {
        staffs = service.findAll();
        return SUCCESS;
    }

    public String findStaffById() {
        getModel().getPost().setPostId(null);
        getModel().getPost().getDept().setDepId(null);
        staffs = service.find(getModel());
        return SUCCESS;
    }

    /**
     * 修改密码
     *
     * @return
     */
    public String changePwd() {
        System.out.println(getModel().getLoginName());
        System.out.println(getModel().getLoginPwd());
        System.out.println(getModel().getNewPassword());
        System.out.println(getModel().getReNewPassword());

        getModel().setLoginPwd(MD5Util.md5(getModel().getNewPassword()));
        service.changePwd(getModel());
        return SUCCESS;
    }

    /**
     * 跳转专用方法
     *
     * @return
     */
    public String jump() {
        return SUCCESS;
    }

    /**
     * 添加员工信息
     *
     * @return
     */
    public String addStaff() {
        if (StringUtils.isBlank(getModel().getStaffId())) {
            getModel().setStaffId(null);
        }
        service.saveOrUpdate(getModel());
        return SUCCESS;
    }

    /**
     * 根据条件查询信息
     *
     * @return
     */
    public String queryInfo() {
        staffs = service.find(getModel());
        return SUCCESS;
    }

    /**
     * 更新员工信息
     *
     * @return
     */
    public String saveStaff() {
        getModel().setStaffId(null);
        return SUCCESS;
    }

    /**
     * 所有部门
     *
     * @return
     */
    public String allDepartment() {
        departments = service.findAllDept();
        return SUCCESS;
    }

    /**
     * 根据部门
     *
     * @return
     */
    public String allPost() {
        System.out.println(depId);
        posts = service.findAllPost(depId);
        return SUCCESS;
    }

    /**
     * 高级查询
     *
     * @return
     */
    public String expertFind() {
        staffs = service.expertFind(getModel());
        return SUCCESS;
    }

    /**
     * 添加员工验证器
     */
    public void validateAddStaff() {
        super.validate();
        if (StringUtils.isBlank(getModel().getPost().getPostId())) {
            addFieldError("postIdError", "请选择部门");
        } else if (StringUtils.isBlank(getModel().getLoginName())) {
            addFieldError("loginNameError", "请填写账户");
        } else if (StringUtils.isBlank(getModel().getLoginPwd())) {
            addFieldError("loginPwdError", "请填写登录密码");
        } else if (StringUtils.isBlank(getModel().getStaffName())) {
            addFieldError("staffNameError", "请填写姓名");
        } else if (StringUtils.isBlank(getModel().getGender())) {
            addFieldError("genderError", "请选择性别");
        } else if (StringUtils.isBlank(getModel().getOnDutyDate().toString())) {
            addFieldError("onDutyDateError", "请选择日期");
        }
    }

    /**
     * 登录验证
     */
    public void validateLogin() {
        super.validate();
        if(getModel().getLoginName().equals("") || getModel().getLoginPwd().equals("")){
            addFieldError("error","账户或者密码不能为空");
        }else {
            getModel().setLoginPwd(MD5Util.md5(getModel().getLoginPwd()));
            System.out.println(getModel().getLoginPwd());
            staffs = service.login(getModel());
            System.out.println("================================" + staffs);
            if (staffs == null) {
                addFieldError("error", "账户或者密码错误");
            }
        }
    }

    /**
     * 更改密码校验
     */
    public void validateChangePwd() {
        super.validate();
        if (StringUtils.isBlank(getModel().getLoginPwd())) {
            addFieldError("error", "请填入原始密码");
        }
        if (StringUtils.isBlank(getModel().getNewPassword())) {
            addFieldError("error", "请填入新密码");
        }

        if (!getModel().getNewPassword().equals(getModel().getReNewPassword())) {
            addFieldError("error", "两次密码输入不一致,请重新输入");
        }

        if (service.findStaff(getModel()) == null) {
            addFieldError("error", "原始密码错误");
        }
    }

    /**
     * get & set 方法
     *
     * @return
     */
    public StaffService getService() {
        return service;
    }

    public void setService(StaffService service) {
        this.service = service;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }
}
