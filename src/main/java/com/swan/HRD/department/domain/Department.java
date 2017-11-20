package com.swan.HRD.department.domain;

import com.swan.HRD.post.domain.Post;
import com.swan.HRD.staff.domain.Staff;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/9.
 */
public class Department {
    private String depId;  //部门ID
    private String depName;     //部门名称
    private Set<Post> posts = new HashSet<Post>();  //部门对应职务


    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Department(String depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public Department(String depId, String depName, Set<Post> posts) {
        this.depId = depId;
        this.depName = depName;
        this.posts = posts;
    }

    public Department(String depName) {
        this.depName = depName;
    }

    public Department() {
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }


    @Override
    public String toString() {
        return "Department{" +
                "depId='" + depId + '\'' +
                ", depName='" + depName + '\'' +
                '}';
    }
}
