<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String no = request.getParameter("no");
HashMap<String,Object> hm = new HashMap<String,Object>();
hm.put("no",Integer.parseInt(no)+1);
hm.put("id","test");
hm.put("name","홍길동");
hm.put("age",1);
hm.put("gender","female");
hm.put("address","서울");

Gson gs = new Gson();
out.println(gs.toJson(hm));
%>