package com.swan.HRD.post.service.impl;

import com.swan.HRD.department.domain.Department;
import com.swan.HRD.post.dao.PostDao;
import com.swan.HRD.post.domain.Post;
import com.swan.HRD.post.service.PostService;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.Base64;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PostServiceImpl implements PostService {

    @Resource
    private PostDao postDao;

    /**
     * 查询所有职务信息
     * @return
     */
    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public List<Post> find(Post post) {
       return postDao.find(post);

    }

    /**
     * 添加职务信息
     * @param post
     */
    @Override
    public void saveOrUpdate(Post post) {
        if(StringUtils.isBlank(post.getPostId())){
            post.setPostId(null);
        }
        postDao.saveOrUpdate(post);
    }

    /**
     * 查询所有部门信息
     * @return
     */
    @Override
    public List<Department> findAllDept() {
        return postDao.findAllDept();
    }

    /**
     * get & set 方法
     * @return
     */
    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

}
