package com.demo.service;

import com.demo.common.model.User;
import com.demo.common.model.UserInfo;
import com.jfinal.plugin.activerecord.Page;

public class UserService {

	public static User login(String userName, String password) {
		String sql = "select * from user where userName = '" + userName
				+ "' and password = '" + password + "'";
		return User.dao.findFirst(sql);
	}

	public static Page<UserInfo> list(int pageNumber, int pageSize) {
		return UserInfo.dao.paginate(pageNumber, pageSize, "select * ",
				"from user_info order by createTime asc");
	}

	public static Page<UserInfo> listLike(int pageNumber, int pageSize,
			String value) {
		return UserInfo.dao.paginate(pageNumber, pageSize, "select * ",
				"FROM user_info WHERE concat(name,',',phone,',',email,',',qq) LIKE '%"
						+ value + "%' order by createTime asc");
	}

}
