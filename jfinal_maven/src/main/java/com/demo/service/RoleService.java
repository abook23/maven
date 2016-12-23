package com.demo.service;

import com.demo.common.model.Role;
import com.jfinal.plugin.activerecord.Page;

public class RoleService {

	public static Page<Role> list(int pageNumber, int pageSize) {
		return Role.dao.paginate(pageNumber, pageSize, "select * ",
				"from role order by createTime asc");
	}
}
