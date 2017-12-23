package com.test.iot.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.ClassDAO;
import com.test.iot.dao.UserDAO;

public class ClassDAOImpl implements ClassDAO{

	@Override
	public ArrayList<HashMap<String, Object>> selectClassList() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<HashMap<String, Object>> classList = new ArrayList<HashMap<String, Object>>();
		String sql = "select * from class_info";
		try {
			ps = DBCon.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) { //밑으로 내리고 있는지 없는지 확인 후 return
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("cino", rs.getString("cino"));
				hm.put("ciname", rs.getString("ciname"));
				hm.put("cidesc", rs.getString("cidesc"));
				classList.add(hm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classList;
	}

	@Override
	public HashMap<String, Object> selectClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertClass() {
		PreparedStatement ps = null;
		String resultStr = null;
		int result=0;
		String sql = "insert into class_info(ciname,cidesc) values ('케빈','나홀로집에')";
		try {
			ps = DBCon.getCon().prepareStatement(sql);
			result = ps.executeUpdate();
			
			if(result>=1) {
				resultStr = "클래스입력성공!";
			}else {
				resultStr = "클래스입력실패!";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultStr;
	}

	@Override
	public String updateClass() {
		PreparedStatement ps = null;
		String resultStr = null;
		int result=0;
		String sql = "update class_info set cidesc='나홀로집에 재밌다' where ciname='케빈'";
		try {
			ps = DBCon.getCon().prepareStatement(sql);
			result = ps.executeUpdate();
			
			if(result>=1) {
				resultStr = "클래스업데이트성공!";
			}else {
				resultStr = "클래스업데이트실패!";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultStr;
	}

	@Override
	public String deleteClass() {
		PreparedStatement ps = null;
		String resultStr = null;
		int result=0;
		String sql = "delete from class_info where ciname='케빈'";
		try {
			ps = DBCon.getCon().prepareStatement(sql);
			result = ps.executeUpdate();
			
			if(result>=1) {
				resultStr = "클래스삭제성공!";
			}else {
				resultStr = "클래스삭제실패!";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultStr;
	}

}
