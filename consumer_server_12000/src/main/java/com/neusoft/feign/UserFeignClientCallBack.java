package com.neusoft.feign;

import org.springframework.stereotype.Component;

import com.neusoft.po.CommonResult;
import com.neusoft.po.User;

@Component
public class UserFeignClientCallBack implements UserFeignClient{
	
	@Override
	public CommonResult<User> getUserById(Integer userId) {
		// 403：请求被服务器拒绝
		return new CommonResult(403, "Feign触发了熔断降级方法", null);
	}
}
