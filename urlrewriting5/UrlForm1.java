package com.sessionmanagment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/next1")
public class UrlForm1 extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
	    String uname=req.getParameter("uname");
	    String password=req.getParameter("upass");
	    pw.print("Servlet 1");
	    pw.print("<center><a href='next2?uname="+uname+"&upass="+password+"'>click here</a></center>");
		
	}

}
