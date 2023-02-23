package com.neusoft.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.neusoft.po.CommonResult;
import com.neusoft.po.User;

@FeignClient(name="provider-server", fallback=UserFeignClientCallBack.class)	//要调用的微服务名
public interface UserFeignClient {
	
	@GetMapping("/user/getUserById/{userId}")
	public CommonResult<User> getUserById(@PathVariable("userId") Integer userId);
}
