package com.demo.controller.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabTable {
	private int draw;
	private int start;
	private int length;
	private String searchValue;
	private boolean searchRegex;
	private int pageNumber;
	private List<Column> columns;
	private List<?> data;
	private int recordsTotal;
	

	/**
	 * dataTable 数据封装
	 * @param data			返回给客户端的list数据
	 * @param recordsTotal	一共有多少条数据
	 */
	public Map<String, Object> getResponseData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("draw", draw);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered", recordsTotal);
		map.put("data", data);
		return map ;
	}
	
	public void setData(List<?> data) {
		this.data = data;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	
	public int getPageNumber() {
		return getStart()/getLength()+1;
	}
	
	public int getPageSize() {
		return getLength();
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
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

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

}
