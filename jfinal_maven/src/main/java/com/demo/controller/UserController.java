package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.util.ajax.JSON;

import com.demo.Key;
import com.demo.common.model.MsgBean;
import com.demo.common.model.User;
import com.demo.common.model.UserInfo;
import com.demo.controller.base.BaseController;
import com.demo.controller.model.DatabTable;
import com.demo.interceptor.BaseInterceptor;
import com.demo.service.UserService;
import com.demo.util.IdUtils;
import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Page;

public class UserController extends BaseController {

	public void add() {
		render("add.html");
	}

	public void login() {
		MsgBean msgBean = new MsgBean();

		User user = getModel(User.class, "");
		user = UserService.login(user.getUserName(), user.getPassword());
		if (user != null) {
			user.setPassword("******");
			setSessionAttr(Key.KEY_SESSION_USER, user);
			msgBean.setMsg("欢迎" + user.getUserName());
		} else {
			msgBean.setStatus(0);
			msgBean.setMsg("用户名或者密码错误");
		}
		renderJson(msgBean);
	}

	@Before({ BaseInterceptor.class })
	public void list() {
		// int page = getAttrForInt("page");
		// int pageSize = getAttrForInt("pageSize");
		User user = getSessionUer();
		String userName = user.getUserName();
		if ("admin".equals(userName) || "system".equals(userName)) {
			Page<UserInfo> userInfoPage = UserService.list(1, 10);
			setAttr("userInfoPage", userInfoPage);
		}
		render("list.html");
	}

	public void list2() {
		DatabTable databTable =  getDataTable();
		String search="";
		User user = getSessionUer();
		String userName = user.getUserName();
		if ("admin".equals(userName) || "system".equals(userName)) {

			int pageNumber = databTable.getStart()/databTable.getLength()+1;
			int pageSize = databTable.getLength();
			if (search==null || search.length()==0) {
				Page<UserInfo> page = UserService.list(pageNumber, pageSize);
				databTable.setData(page.getList());
				databTable.setRecordsTotal(page.getTotalRow());
			}else {
				Page<UserInfo> page = UserService.listLike(pageNumber, pageSize,search);
			}
			renderJson(databTable.getResponseData());
		} else {
			renderJson();
		}

	}

	@Before({ BaseInterceptor.class })
	public void edit() {

		MsgBean msgBean = new MsgBean();

		User user = getModel(User.class);
		UserInfo userInfo = getModel(UserInfo.class);

		if ("******".equals(user.getPassword())) {
			user.setPassword(null);
		}

		if (user.getUserId() == null) {
			user.setUserId(IdUtils.getId());
			user.setUserName(userInfo.getName());

			userInfo.setUserId(user.getUserId());
			boolean b = user.save();
			boolean b2 = userInfo.save();
			if (b && b2) {
				msgBean.setStatus(1);
				msgBean.setMsg("新增成功");
			} else {
				user.delete();
				userInfo.delete();

				msgBean.setStatus(0);
				msgBean.setMsg("失败成功");
			}
		} else {

			/**
			 * system 可以修改所以用户的密码 普通用户只能修改本用户的密码
			 */
			if ("system".equals(getSessionUer().getUserName())
					|| getSessionUer().getUserId().equals(user.getUserId())) {
				user.update();
				userInfo.setUserId(user.getUserId());
				boolean b = userInfo.update();
				if (b) {
					msgBean.setStatus(1);
					msgBean.setMsg("更新成功");
				} else {
					msgBean.setStatus(0);
					msgBean.setMsg("更新失败");
				}
			} else {
				msgBean.setStatus(0);
				msgBean.setMsg("权限不足,不能修改他人信息");
			}
		}
		renderJson(msgBean);
	}

	@Before({ BaseInterceptor.class })
	public void info() {
		String id = getPara("id");
		int type = getPara("type") == null ? 0 : getParaToInt("type");
		UserInfo userInfo = UserInfo.dao.findById(id);
		User user = User.dao.findById(id);
		user.setPassword("******");
		setAttr("userInfo", userInfo);
		setAttr("user", user);
		if (type == 0) {
			render("info.html");
		} else {
			render("add.html");
		}
	}

	@Before({ BaseInterceptor.class })
	public void delete() {
		MsgBean msgBean = new MsgBean();
		String id = getPara("id");
		boolean b = UserInfo.dao.deleteById(id);
		if (b) {
			msgBean.setStatus(1);
			msgBean.setMsg("删除成功");
		} else {
			msgBean.setStatus(0);
			msgBean.setMsg("删除失败");
		}
		renderJson(msgBean);
	}

	@Override
	public void updat() {
		// TODO Auto-generated method stub
		
	}
}
