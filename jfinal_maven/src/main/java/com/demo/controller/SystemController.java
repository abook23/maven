package com.demo.controller;

import com.demo.common.model.Menu;
import com.demo.common.model.User;
import com.demo.common.model.UserInfo;
import com.demo.common.model.UserMenu;
import com.demo.util.IdUtils;
import com.jfinal.core.Controller;

public class SystemController extends Controller {

	private String userId;
	
	public void index() {
		
		User user = User.dao.findFirst("select * from user where userName = 'system'");
		if(user==null){
			user = addSystemUser();
			userId = user.getUserId();
			
			String pId = IdUtils.getId();
			addMenu("0", pId, "系统管理",null);
			addMenu(pId, IdUtils.getId(), "菜单管理","/menu/list");
			addMenu(pId, IdUtils.getId(), "角色管理","/rolo/list");
			addMenu(pId, IdUtils.getId(), "用户管理","/user/list");
			
			UserMenu userMenu = new UserMenu();
			userMenu.setMenuId(pId);
			userMenu.setUserId(pId);
		}
		redirect("/login.html");
		
	}
	
	
	public void addMenu(String pId,String id,String name,String url) {
		Menu menu = new Menu();
		menu.setMenuId(id);
		menu.setPId(pId);
		menu.setName(name);
		menu.setStatus(1);
		menu.setUrl(url);
		menu.save();
		addUserMenu(userId, id);
		
	}
	
	private User addSystemUser(){
		User user = new User();
		user.setUserId(IdUtils.getId());
		user.setUserName("system");
		user.setPassword("system");
		user.setStatus(1);
		user.save();
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(user.getUserId());
		userInfo.setName(user.getUserName());
		userInfo.setPhone("888888");
		userInfo.setEmail("888888@qq.com");
		userInfo.save();
		
		return user;
	}
	
	private void addUserMenu(String userId,String menuId) {
		UserMenu userMenu = new UserMenu();
		userMenu.setUserId(userId);
		userMenu.setMenuId(menuId);
		userMenu.setStatus(1);
		userMenu.save();
	}

}
