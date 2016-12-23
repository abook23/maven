package com.demo.service;

import java.util.List;

import javax.management.relation.Role;

import com.demo.common.model.Menu;
import com.demo.common.model.UserMenu;

public class MenuService {
	public static List<Menu> list(String userId) {
		String sql = "select m.menuId,m.pId,m.name,m.url from menu m,user_menu um where um.userId = '"+userId+"' and m.menuId = um.menuId";
		return Menu.dao.find(sql);
	}
}
