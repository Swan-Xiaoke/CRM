package com.swan.HRD.post.action;

import com.swan.HRD.department.domain.Department;
import com.swan.HRD.department.service.DeptService;
import com.swan.HRD.post.domain.Post;
import com.swan.HRD.post.service.PostService;
import com.swan.utils.BaseAction;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 * 注解使用与xml重复
 */
public class PostAction extends BaseAction<Post, PostService> {
    private List<Post> posts;
    private DeptService deptService;

    private List<Department> departments;

    /**
     * 查询所有职称
     *
     * @return
     */
    public String allPost() {
        posts = service.findAll();
        return SUCCESS;
    }

    public String findPostByDepId() {
        posts = service.find(getModel());
        return SUCCESS;
    }

    /**
     * 跳转到添加页面前的准备工作
     *
     * @return
     */
    public String jump() {
        //跳转页面之前 需要查出所有的部门
        departments = service.findAllDept();
        return SUCCESS;
    }

    /**
     * 保存添加的职务信息
     *
     * @return
     */
    public String save() {
        service.saveOrUpdate(getModel());
        return SUCCESS;
    }

    public void validateSave() {
        super.validate();
        if (StringUtils.isBlank(getModel().getDept().getDepId())) {
            addFieldError("deptError", "请选择部门");
        }
        if(StringUtils.isBlank(getModel().getPostName())){
            addFieldError("postError","请填入职务名称");
        }
    }

    /**
     * get & set 方法
     *
     * @return
     */
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
