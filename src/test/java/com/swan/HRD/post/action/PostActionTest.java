package com.swan.HRD.post.action;

import com.swan.HRD.department.domain.Department;
import com.swan.HRD.department.service.DeptService;
import com.swan.HRD.post.domain.Post;
import com.swan.HRD.post.service.PostService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * 测试类
 * Created by dllo on 17/11/13.
 */
public class PostActionTest {

    /**
     * 验证跳转到查出所有职位信息
     */
    @Test
    public void findPost(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        PostService postService= (PostService) ctx.getBean("postService");
        System.out.println(postService.findAll());
    }

    /**
     * 根据部门ID查询出对应的职位
     */
    @Test
    public void findPostByDepId(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        PostService postService= (PostService) ctx.getBean("postService");
        Department department = new Department();
        department.setDepId("ee050687bd1a4455a153d7bbb7000001");
        Post post = new Post();
        post.setDept(department);
        System.out.println(postService.find(post));
    }


}