package com.test.iot.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface ClassService {

	public ArrayList<HashMap<String,Object>> getClassList();
	public HashMap<String, Object> getClassOne();
	public String getInsertResult();
	public String getUpdateResult();
	public String getDeleteResult();
}
