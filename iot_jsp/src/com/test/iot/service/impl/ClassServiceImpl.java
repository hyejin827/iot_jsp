package com.test.iot.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.ClassDAO;
import com.test.iot.dao.impl.ClassDAOImpl;
import com.test.iot.service.ClassService;

public class ClassServiceImpl implements ClassService{

	private ClassDAO cd = new ClassDAOImpl();

	@Override
	public ArrayList<HashMap<String, Object>> getClassList() {
		Connection con = DBCon.getCon();
		ArrayList<HashMap<String, Object>> classList = cd.selectClassList();
//		DBCon.closeCon();
		return classList;
	}

	@Override
	public HashMap<String, Object> getClassOne() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getInsertResult() {
		Connection con = DBCon.getCon();
		String result = cd.insertClass();
		return result;
	}

	@Override
	public String getUpdateResult() {
		Connection con = DBCon.getCon();
		String result = cd.updateClass();
		return result;
	}

	@Override
	public String getDeleteResult() {
		Connection con = DBCon.getCon();
		String result = cd.deleteClass();
		return result;
	}

}
