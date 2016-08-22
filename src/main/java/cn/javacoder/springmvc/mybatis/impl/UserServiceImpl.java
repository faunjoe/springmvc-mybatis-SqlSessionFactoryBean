package cn.javacoder.springmvc.mybatis.impl;

import cn.javacoder.springmvc.mybatis.dao.UserDao;
import cn.javacoder.springmvc.mybatis.entity.User;
import cn.javacoder.springmvc.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by aijun.fu@mtime.com
 * Date:2016/8/14
 * Time:1:52
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserById(int userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
