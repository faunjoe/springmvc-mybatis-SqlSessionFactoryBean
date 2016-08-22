package cn.javacoder.springmvc.mybatis.service;

import cn.javacoder.springmvc.mybatis.entity.User;

/**
 * Created by aijun.fu@mtime.com
 * Date:2016/8/14
 * Time:1:48
 */
public interface UserService {
    User selectUserById(int userId);

    void insertUser(User user);
}
