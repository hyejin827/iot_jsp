package com.test.iot.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.UserDAO;

public class UserDAOImpl implements UserDAO{

	@Override
	public ArrayList<HashMap<String, Object>> selectUserList() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<HashMap<String, Object>> userList = new ArrayList<HashMap<String, Object>>();
		String sql = "select * from user_info";
		try {
			ps = DBCon.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) { //밑으로 내리고 있는지 없는지 확인 후 return
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("uino", rs.getString("uino"));
				hm.put("uiname", rs.getString("uiname"));
				hm.put("uiage", rs.getString("uiage"));
				hm.put("uiid", rs.getString("uiid"));
				hm.put("uipwd", rs.getString("uipwd"));
				hm.put("cino", rs.getString("cino"));
				hm.put("address", rs.getString("address"));
				userList.add(hm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public HashMap<String, Object> selectUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertUser() {
		PreparedStatement ps = null;
		String resultStr = null;
		int result=0;
		String sql = "insert into user_info(uiname,uiage,uiid,uipwd,cino,address) values ('케빈',8,'alone','alone',1,'나홀로집에')";
		try {
			ps = DBCon.getCon().prepareStatement(sql);
			result = ps.executeUpdate();
			
			if(result>=1) {
				resultStr = "입력성공!";
			}else {
				resultStr = "입력실패!";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultStr;
	}

	@Override
	public String updateUser() {
		PreparedStatement ps = null;
		String resultStr = null;
		int result=0;
		String sql = "update user_info set uiage=100 where uiname='케빈'";
		try {
			ps = DBCon.getCon().prepareStatement(sql);
			result = ps.executeUpdate();
			
			if(result>=1) {
				resultStr = "업데이트성공!";
			}else {
				resultStr = "업데이트실패!";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultStr;
	}

	@Override
	public String deleteUser() {
		PreparedStatement ps = null;
		String resultStr = null;
		int result=0;
		String sql = "delete from user_info where uiname='케빈'";
		try {
			ps = DBCon.getCon().prepareStatement(sql);
			result = ps.executeUpdate();
			
			if(result>=1) {
				resultStr = "삭제성공!";
			}else {
				resultStr = "삭제실패!";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultStr;
	}

}
