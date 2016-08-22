package cn.javacoder.springmvc.mybatis.impl;

import cn.javacoder.springmvc.mybatis.entity.User;
import cn.javacoder.springmvc.mybatis.service.UserService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by aijun.fu@mtime.com
 * Date:2016/8/19
 * Time:11:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:etc/spring/spring-servlet.xml","classpath:etc/spring/spring-mybatis.xml"})
public class UserServiceImplTest {

    @Autowired
    private UserService UserService;

    @Test
    public void testSelectUserById() throws Exception {
        User user = UserService.selectUserById(4);
        System.out.println(JSON.toJSONString(user));
    }
}