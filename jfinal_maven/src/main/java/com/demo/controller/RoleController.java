package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.demo.common.model.Role;
import com.demo.controller.base.BaseController;
import com.demo.controller.model.DatabTable;
import com.demo.service.RoleService;
import com.jfinal.plugin.activerecord.Page;

public class RoleController extends BaseController {

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		render("list.html");
	}
	
	public void listData() {
		// TODO Auto-generated method stub
		DatabTable dt = getDataTable();
		Page<Role> page = RoleService.list(dt.getPageNumber(), dt.getPageSize());
		dt.setData(page.getList());
		renderJson(dt.getResponseData());
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
