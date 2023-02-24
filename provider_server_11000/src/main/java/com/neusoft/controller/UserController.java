package com.neusoft.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.po.CommonResult;
import com.neusoft.po.User;

@RestController
@RequestMapping("/user")
@RefreshScope		//开启动态刷新
public class UserController {
	
	@Value("${msg}")
	private String msg;
	
	@GetMapping("/getUserById/{userId}")
	public CommonResult<User> getUserById(@PathVariable("userId") Integer userId) {
		return new CommonResult(200, "success(11000) (msg:"+msg+")", new User(userId, "张三", "123"));
	}
}
