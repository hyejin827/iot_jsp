package com.test.iot.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface ClassDAO {
	public ArrayList<HashMap<String,Object>> selectClassList();
	public HashMap<String,Object> selectClass();
	public String insertClass();
	public String updateClass();
	public String deleteClass();
}
