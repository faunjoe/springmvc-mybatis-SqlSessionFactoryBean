package cn.javacoder.springmvc.mybatis.web;

import cn.javacoder.springmvc.mybatis.entity.User;
import cn.javacoder.springmvc.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("helloWorld")
	public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = userService.selectUserById(1);
		response.getWriter().write(user.toString());
	}

	@RequestMapping("insert")
	public void insert(HttpServletResponse response ) throws IOException{
		User user = new User();
		user.setUserName("mtime");
		user.setPassword("mtime123456");
		String result = "";
		try{
			userService.insertUser(user);
			result = " OK!";
		}catch(Exception e){
			result = "Roll Back";
		}
		response.getWriter().write(result);
	}

	@RequestMapping("getUser")
	public String getUser(Model model){
		User user = userService.selectUserById(1);
		model.addAttribute("user",user);
		return "userdetail";
	}

	@RequestMapping("testAccept")
	@ResponseBody
	public User testAccept() {
		User user = userService.selectUserById(1);
		return user;
	}

	@RequestMapping("testBind")
	@ResponseBody
	public User testBind(User user){
		return user;
	}
}
