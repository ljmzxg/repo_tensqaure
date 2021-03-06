package com.iv.tensquare.friend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iv.tensquare.friend.client.UserClient;
import com.iv.tensquare.friend.service.FriendService;

import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/friend")
@RefreshScope
public class FriendController {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private FriendService friendService;
	
	@Autowired
	private UserClient userClient;
	
	/**
	 * 删除好友
	 * @return
	 */
	@RequestMapping(value = "/{friendid}", method = RequestMethod.DELETE)
	public Result deleteFriend(@PathVariable String friendid) {
		//验证是否登录，并且拿到当前登录用户的id
		Claims claims = (Claims) request.getAttribute("claims_user");
		if(claims == null) {
			return new Result(false, StatusCode.ERROR, "权限不足");
		}
		//得到当前登录用户id
		String userid = claims.getId();
		friendService.deleteFriend(userid, friendid);
		userClient.updateFanscountAndFollowcount(userid, friendid, -1);
		return new Result(true, StatusCode.OK, "删除好友成功");
	}
	@RequestMapping(value = "/like/{friendid}/{type}", method = RequestMethod.PUT)
	public Result addFriend(@PathVariable String friendid, @PathVariable String type) {
		//验证是否登陆，并且拿到当前登陆的用户id
		Claims claims = (Claims) request.getAttribute("claims_user");
		if(claims == null) {
			//当前用户没有user 角色
			return new Result(false, StatusCode.LOGINERROR, "权限不足");
		}
		//得到当前登陆用户id
		String userid = claims.getId();
		if(type != null) {
			if("1".equals(type)) {
				//添加好友
				int flag = friendService.addFriend(userid, friendid);
				if(flag == 0) {
					return new Result(false, StatusCode.ERROR, "不能重复添加好友");
				}
				if(flag == 1) {
					userClient.updateFanscountAndFollowcount(userid, friendid, 1);
					return new Result(true, StatusCode.OK, "添加成功");
				}
				
			} else if("2".equals(type)) {
				//添加非好友
				int flag = friendService.addNoFriend(userid, friendid);
				if(flag == 0) {
					return new Result(false, StatusCode.ERROR, "不能重复添加非好友");
				}
				
				if(flag == 1) {
					return new Result(true, StatusCode.OK, "添加成功");
				}
				
			}
			return new Result(false, StatusCode.ERROR, "参数异常");
		} 
		
		return new Result(false, StatusCode.ERROR, "参数异常");
	}
	
	
}
