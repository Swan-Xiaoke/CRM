package com.swan.HRD.staff.action;

import com.swan.HRD.department.domain.Department;
import com.swan.HRD.department.service.DeptService;
import com.swan.HRD.post.domain.Post;
import com.swan.HRD.staff.domain.Staff;
import com.swan.HRD.staff.service.StaffService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffActionTest {

    /**
     * 验证登录方法
     */
    @Test
    public void loginTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        StaffService staffService = (StaffService) ctx.getBean("staffService");
        Staff s = new Staff();
        s.setLoginName("root");
        s.setLoginPwd("root");
        System.out.println(staffService.login(s));
    }

    /**
     * 验证查找所有员工信息
     */
    @Test
    public void findAll(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        StaffService staffService = (StaffService) ctx.getBean("staffService");
        Staff staff = new Staff();
        System.out.println(staffService.findAll());

    }

    /**
     * 验证添加员工
     */
    @Test
    public void addTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        StaffService staffService = (StaffService) ctx.getBean("staffService");
        Staff s = new Staff();
        s.setStaffId("111");
        s.setLoginName("swan");
        s.setLoginPwd("swan");
    }

    /**
     * 验证查询所有部门
     */
    @Test
    public void allDept(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        StaffService staffService = (StaffService) ctx.getBean("staffService");
        System.out.println(staffService.findAllDept());
    }

    /**
     * 验证查询对应职务
     */
    @Test
    public void allPost(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        StaffService staffService = (StaffService) ctx.getBean("staffService");
        Post post = new Post();
        Department department = new Department();
        String st = "ee050687bd1a4455a153d7bbb7000002";
        System.out.println(staffService.findAllPost(st));
    }

}