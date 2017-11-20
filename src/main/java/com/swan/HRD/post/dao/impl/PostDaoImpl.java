package com.swan.HRD.post.dao.impl;

import com.swan.HRD.department.domain.Department;
import com.swan.HRD.post.dao.PostDao;
import com.swan.HRD.post.domain.Post;
import com.swan.utils.BaseDao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

    /**
     * 查询出所有的职务信息
     *
     * @return
     */
    @Override
    public List<Post> findAll() {
        List<Post> posts = getHibernateTemplate().loadAll(Post.class);
        return posts;
    }

    /**
     * @param post
     * @return
     */
    @Override
    public List<Post> find(Post post) {
        return (List<Post>) getHibernateTemplate().find("from Post where dept.depId = ?", post.getDept().getDepId());
    }

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Department> findAllDept() {
        return getHibernateTemplate().loadAll(Department.class);
    }

    /**
     * 添加职务
     *
     * @param post
     */
    @Override
    public void saveOrUpdate(Post post) {
        if (post.getPostId() == null) {
            getHibernateTemplate().saveOrUpdate(post);
        }else {
            getHibernateTemplate().update(post);
        }
    }
}
