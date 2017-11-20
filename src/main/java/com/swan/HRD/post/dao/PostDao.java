package com.swan.HRD.post.dao;

import com.swan.HRD.department.domain.Department;
import com.swan.HRD.post.domain.Post;
import com.swan.utils.BaseDao;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface PostDao extends BaseDao<Post>{

    List<Department> findAllDept();
}

