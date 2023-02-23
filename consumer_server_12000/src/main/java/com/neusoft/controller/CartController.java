package com.neusoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.neusoft.feign.UserFeignClient;
import com.neusoft.po.CommonResult;
import com.neusoft.po.User;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/getUserById/{userId}")
	public CommonResult getUserById(@PathVariable("userId") Integer userId) {
		//CommonResult<User> result = restTemplate.getForObject("http://provider-server/user/getUserById/" + userId, CommonResult.class);
		return userFeignClient.getUserById(userId);
	}
}
