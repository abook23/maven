package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseLogging<M extends BaseLogging<M>> extends Model<M> implements IBean {

	public void setLogId(String logId) {
		set("logId", logId);
	}

	public String getLogId() {
		return get("logId");
	}

	public void setUserId(String userId) {
		set("userId", userId);
	}

	public String getUserId() {
		return get("userId");
	}

	public void setDateTime(java.util.Date dateTime) {
		set("dateTime", dateTime);
	}

	public java.util.Date getDateTime() {
		return get("dateTime");
	}

	public void setType(String type) {
		set("type", type);
	}

	public String getType() {
		return get("type");
	}

	public void setIp(String ip) {
		set("ip", ip);
	}

	public String getIp() {
		return get("ip");
	}

	public void setAddr(String addr) {
		set("addr", addr);
	}

	public String getAddr() {
		return get("addr");
	}

}
