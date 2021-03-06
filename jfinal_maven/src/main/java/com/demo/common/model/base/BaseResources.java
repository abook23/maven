package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseResources<M extends BaseResources<M>> extends Model<M> implements IBean {

	public void setResId(String resId) {
		set("resId", resId);
	}

	public String getResId() {
		return get("resId");
	}

	public void setName(String name) {
		set("name", name);
	}

	public String getName() {
		return get("name");
	}

	public void setPath(String path) {
		set("path", path);
	}

	public String getPath() {
		return get("path");
	}

	public void setType(String type) {
		set("type", type);
	}

	public String getType() {
		return get("type");
	}

	public void setMd5(String md5) {
		set("md5", md5);
	}

	public String getMd5() {
		return get("md5");
	}

	public void setDateTime(java.util.Date dateTime) {
		set("dateTime", dateTime);
	}

	public java.util.Date getDateTime() {
		return get("dateTime");
	}

	public void setStatus(Integer status) {
		set("status", status);
	}

	public Integer getStatus() {
		return get("status");
	}

}
