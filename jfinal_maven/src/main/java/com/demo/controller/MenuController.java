package com.demo.controller;

import java.util.List;

import com.demo.common.model.Menu;
import com.demo.common.model.User;
import com.demo.common.model.UserMenu;
import com.demo.controller.base.BaseController;
import com.demo.interceptor.BaseInterceptor;
import com.demo.service.MenuService;
import com.jfinal.aop.Before;

@Before({BaseInterceptor.class})
public class MenuController extends BaseController {

	public void list() {
		User user = getSessionUer();
		List<Menu> menus = MenuService.list(user.getUserId());
		renderJson(menus);
	}
	
	public void add() {
		getModel(Menu.class).save();
	}
	
	public void setUserMenu() {
		User user = getSessionUer();
		UserMenu userMenu = getModel(UserMenu.class);
	}

	@Override
	public void updat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
