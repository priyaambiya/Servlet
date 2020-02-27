package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/page")
public class HttpServletDemo1 extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	resp.setContentType("text/html");
	PrintWriter p=resp.getWriter();
	p.print("<html><body>"
			+"<center><h4>this is my servlet page</h4>"
			+"<table><form action='#' method='get'>"
	+"<tr><td>Username<input type='text' name=uname></td></tr>"
	+"<tr></td>Password<input type='password' name='pass'></td></tr>"
	+ "<tr><td><input type=submit value='login'></td></tr>"
	+ "</form></center></body></html>");
	}

}
