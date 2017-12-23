package com.test.iot.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.iot.service.ClassService;
import com.test.iot.service.UserService;
import com.test.iot.service.impl.ClassServiceImpl;
import com.test.iot.service.impl.UserServiceImpl;

public class ClassServlet extends HttpServlet {

	ClassService cs = new ClassServiceImpl();

	public String getCommand(String uri) {
		int idx = uri.lastIndexOf("/");
		if (idx != -1) {
			return uri.substring(idx + 1);
		}
		return "";
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}

	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");

		String uri = req.getRequestURI();
		System.out.println("uri : " + uri);

		String cmd = getCommand(uri);
		if (cmd.equals("list")) {
			req.setAttribute("list", cs.getClassList());
		} else if (cmd.equals("insert")) {
			req.setAttribute("insert", cs.getInsertResult());
		} else if (cmd.equals("update")){
			req.setAttribute("update", cs.getUpdateResult());
		} else if (cmd.equals("delete")){
			req.setAttribute("delete", cs.getDeleteResult());
		}else {
			cmd = "/common/error";
		}
		uri = "/WEB-INF/view" + uri + ".jsp";
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}
}