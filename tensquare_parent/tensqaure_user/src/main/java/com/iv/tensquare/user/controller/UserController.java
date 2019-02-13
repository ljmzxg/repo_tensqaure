package com.iv.tensquare.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iv.tensquare.user.pojo.User;
import com.iv.tensquare.user.service.UserService;

import entity.Result;
import entity.StatusCode;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 发送短信验证码
	 * @param mobile
	 * @return
	 */
	@RequestMapping(value = "/sendsms/{mobile}", method = RequestMethod.POST)
	public Result sendSms(@PathVariable String mobile) {
		userService.sendSms(mobile);
		return new Result(true, StatusCode.OK, "发送成功");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Result save(@RequestBody User user) {
		userService.save(user);
		return new Result(true, StatusCode.OK, "添加成功");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return new Result(true, StatusCode.OK, "查询成功", userService.findAll());
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Result findById(@PathVariable String userId) {
		return new Result(true, StatusCode.OK, "查询成功", userService.findById(userId));
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public Result updateUser(@RequestBody User user, @PathVariable String userId) {
		user.setId(userId);
		userService.updateUser(user);
		return new Result(true, StatusCode.OK, "更新成功");
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public Result deleteUser(@PathVariable String userId) {
		userService.deleteById(userId);
		return new Result(true, StatusCode.OK, "删除成功");
	}
	
	
}