package com.swan.HRD.department.action;

import com.swan.HRD.department.service.DeptService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/13.
 */
public class DepartmentActionTest {
    //验证跳转到添加界面是否能查出所有部门信息
    @Test
    public void findDept(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        DeptService deptService= (DeptService) ctx.getBean("deptService");
        System.out.println(deptService.findAll());
    }
}