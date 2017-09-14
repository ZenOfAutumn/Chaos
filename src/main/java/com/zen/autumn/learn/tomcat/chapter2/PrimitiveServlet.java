package com.zen.autumn.learn.tomcat.chapter2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PrimitiveServlet implements Servlet {

	public void init(ServletConfig config) throws ServletException {

		System.out.println("init");
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		System.out.println("from service");
		PrintWriter out = res.getWriter();
		out.println("hello world");
		out.println("i'm ceo bitch.");
	}

	public String getServletInfo() {
		return null;
	}

	public void destroy() {

		System.out.println("destroy");
	}

}
