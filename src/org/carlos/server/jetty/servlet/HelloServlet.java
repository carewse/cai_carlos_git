package org.carlos.server.jetty.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1027512193426911561L;

	private String msg = "Hello World!";

	public HelloServlet(){
	}

	public HelloServlet(String msg){
		this.msg = msg;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println("<h1>" + msg + "</h1>");
		response.getWriter().println(" </br>session=" + request.getSession(true).getId() + "</br>");
		if (name != null) {
			response.getWriter().println("12" + name + "</br>");
		}

		if (password != null) {
			response.getWriter().println(" 23" + password + "</br>");
		}

	}
}
