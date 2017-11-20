package com.swan.HRD.post.domain;

import com.swan.HRD.department.domain.Department;
import com.swan.HRD.staff.domain.Staff;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/9.
 */
public class Post {
    private String postId;  //职务ID
    private String postName;    //职务名称
    private Department dept;    //职务对应的部门
    private Set<Staff> staffs = new HashSet<>();    //职务对应的员工

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    public Post(String postId, String postName) {
        this.postId = postId;
        this.postName = postName;
    }

    public Post(String postName) {
        this.postName = postName;
    }

    public Post() {
    }


    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Department getDept() {
        return dept;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }



    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                '}';
    }
}
