package com.zen.autumn.learn.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionPeek extends HttpServlet{
	
	@Override
	public String getServletInfo() {
		return "A session tracking servlet";
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<head><title>SessionPark<title><head>");
		Integer ival = (Integer)session.getAttribute("sesspeek.cntr");
		if(ival==null)
			ival = new Integer(1);
			else
			ival = new Integer(ival.intValue() + 1);
			session.setAttribute("sesspeek.cntr", ival);
			
			out.println("You have hit this page <b>"
					+ ival + "</b> times.<p>");
			Enumeration<String> sesNames = session.getAttributeNames();
			
			while(sesNames.hasMoreElements()) {
				String name =
				sesNames.nextElement().toString();
				Object value = session.getAttribute(name);
				out.println(name + " = " + value + "<br>");
				}
			
			out.println("<h3> Session Statistics </h3>");
			out.println("Session ID: "
			+ session.getId() + "<br>");
			out.println("New Session: " + session.isNew()
			+ "<br>");
			out.println("Creation Time: "
			+ session.getCreationTime());
			out.println("<I>(" +
			new Date(session.getCreationTime())
			+ ")</I><br>");
			out.println("Last Accessed Time: " +
			session.getLastAccessedTime());
			out.println("<I>(" +new Date(session.getLastAccessedTime())+ ")</I><br>");
			out.println("Session Inactive Interval: "
					+ session.getMaxInactiveInterval());
					out.println("Session ID in Request: "
					+ req.getRequestedSessionId() + "<br>");
					out.println("Is session id from Cookie: "
					+ req.isRequestedSessionIdFromCookie()
					+ "<br>");
					out.println("Is session id from URL: "
					+ req.isRequestedSessionIdFromURL()
					+ "<br>");
					out.println("Is session id valid: "
					+ req.isRequestedSessionIdValid()
					+ "<br>");
					out.println("</BODY>");
					out.close();
			
			
			
	}

}
