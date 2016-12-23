package com.demo.controller.model;

public class Column {

	private String data;
	private String name;
	private boolean searchable;
	private boolean orderable;
	private String searchValue;
	private boolean searchRegex;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSearchable() {
		return searchable;
	}
	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}
	public boolean isOrderable() {
		return orderable;
	}
	public void setOrderable(boolean orderable) {
		this.orderable = orderable;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public boolean isSearchRegex() {
		return searchRegex;
	}
	public void setSearchRegex(boolean searchRegex) {
		this.searchRegex = searchRegex;
	}

}
