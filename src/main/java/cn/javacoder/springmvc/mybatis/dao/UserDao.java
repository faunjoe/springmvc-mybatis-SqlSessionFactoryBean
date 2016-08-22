package cn.javacoder.springmvc.mybatis.dao;

import cn.javacoder.springmvc.mybatis.entity.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by aijun.fu@mtime.com
 * Date:2016/8/14
 * Time:1:40
 */
@Repository
public class UserDao extends SqlSessionDaoSupport {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public User selectUserById(int userId) {
        return this.getSqlSession().selectOne("cn.javacoder.springmvc.mybatis.entity.UserMapper.selectUserById",userId);
    }

    @Transactional
    public void insertUser(User user) {
        int i = this.getSqlSession().insert("cn.javacoder.springmvc.mybatis.entity.UserMapper.insertUser",user);
        throw new RuntimeException();
    }
}
