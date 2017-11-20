package com.swan.HRD.department.action;

import com.opensymphony.xwork2.ActionSupport;
import com.swan.HRD.department.domain.Department;
import com.swan.HRD.department.service.DeptService;
import com.swan.utils.BaseAction;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 * 基类使用的不好, Service和Model没有使用, 需要更改
 * git
 */
public class DepartmentAction extends BaseAction<Department,DeptService>{
    private List<Department> departments;

    /**
     * 添加/更新部门信息
     * @return
     */
    public String saveOrUpdateDept() {
        service.saveOrUpdate(getModel());
        return SUCCESS;
    }

    /**
     * 查询所有部门
     * @return
     */
    public String findAllDept() {
        departments = service.findAll();
        return SUCCESS;
    }

    /**
     * 根据ID查找部门信息
     * @return
     */
     public String findDeptById(){
//         departments = service.find(getModel());
         return SUCCESS;
    }

    /**
     * 跳转
     * @return
     */
    public String jump(){
        return SUCCESS;
    }


    /**
     * 方法验证
     */
    public void validateSaveOrUpdateDept() {
        super.validate();
        if(StringUtils.isBlank(getModel().getDepName())){
           addFieldError("deptError","请输入部门名称");
        }
    }

    /**
     * get & set 方法
     * @return
     */
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

}
