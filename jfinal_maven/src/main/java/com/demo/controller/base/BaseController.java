package com.demo.controller.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.demo.Key;
import com.demo.common.model.User;
import com.demo.controller.model.Column;
import com.demo.controller.model.DatabTable;
import com.jfinal.core.Controller;

public abstract class BaseController extends Controller {

	public User getSessionUer() {
		return getSessionAttr(Key.KEY_SESSION_USER);
	}

	public DatabTable getDataTable() {
		
		DatabTable databTable = new DatabTable();
		
		databTable.setDraw(getParaToInt("draw",0));
		databTable.setStart(getParaToInt("start",10));
		databTable.setLength(getParaToInt("length",10));
		databTable.setSearchValue(getPara("search[value]"));
		databTable.setSearchRegex(getParaToBoolean("search[regex]",false));
		
	
		int columnsSize=0;
		Map<String, String[]> maps =getParaMap();
		for (Map.Entry<String, String[]> entry: maps.entrySet()) {
			if(entry.getKey().startsWith("columns")){
				columnsSize++;
			}
		}
		columnsSize = columnsSize/6;
		List<Column> columns = new ArrayList<>();
		for (int i = 0; i < columnsSize; i++) {
			Column column = new Column();
			column.setData(getPara("columns["+i+"][data]"));
			column.setName(getPara("columns["+i+"][name]"));
			column.setSearchValue(getPara("columns["+i+"][search][value]"));
			column.setSearchable(getParaToBoolean("columns["+i+"][searchable]",false));
			column.setSearchRegex(getParaToBoolean("columns["+i+"][search][regex]",false));
			columns.add(column);
		}
		databTable.setColumns(columns);
		
		return databTable;

	}

	abstract public void add();

	abstract public void list();

	abstract public void updat();

	abstract public void delete();
}
